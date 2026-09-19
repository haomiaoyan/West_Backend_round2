package west2.learn_backend.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryTodoRepository implements TodoRepository{
    Map<String, Todo> store = new ConcurrentHashMap<>();

    @Override
    public void save(Todo todo) {
        String id = todo.getId();
        store.put(id, todo);
    }

    @Override
    public Optional<Todo> findById(String id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Todo> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(String id) {
        store.remove(id);
    }
}
