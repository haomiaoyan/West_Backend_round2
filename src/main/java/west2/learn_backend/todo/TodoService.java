package west2.learn_backend.todo;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final TodoRepository repo;  // 依赖接口，不依赖实现
    private final AtomicLong seq = new AtomicLong();    // 发号的计数器

    public TodoService(TodoRepository repo){    // 构造注入
        this.repo = repo;
    }

    public Todo create(String title, String content){
        Todo t = new Todo();
        t.setId(String.valueOf(seq.incrementAndGet()));
        t.setTitle(title);
        t.setContent(content);
        t.setCompleted(Boolean.FALSE);

        Instant now = Instant.now();
        t.setCreatedAt(now);
        t.setUpdatedAt(now);
        repo.save(t);
        return t;
    }

    public Todo findById(String id){
        return repo.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public List<Todo> findAll(){
        return repo.findAll();
    }

    public Todo update(String id, Todo patch){
        Todo t = findById(id);  // 确认是否存在
        if (patch.getTitle() != null)   // 如果存在，才进行覆盖
            t.setTitle(patch.getTitle());

        if (patch.getContent() != null)
            t.setContent(patch.getContent());

        if (patch.getCompleted() != null)
            t.setCompleted(patch.getCompleted());

        t.setUpdatedAt(Instant.now());
        repo.save(t);
        return t;
    }

    public void delete(String id){
        findById(id);   // 先确认是否存在
        repo.deleteById(id);
    }
}
