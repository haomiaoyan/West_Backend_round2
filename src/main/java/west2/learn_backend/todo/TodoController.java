package west2.learn_backend.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service){ // 依旧构造注入
        this.service = service;
    }   // 构造注入

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo t){
        if (t.getTitle() == null || t.getContent() == null){
            return ResponseEntity.badRequest().build();
        }
        Todo created = service.create(t.getTitle(), t.getContent());
        return ResponseEntity.status(201).body(created);    // 构建http响应对象
    }


    @GetMapping
    public List<Todo> findAll(){
        return service.findAll();
    }

    @PatchMapping("/{id}")
    public Todo update(@PathVariable String id,
                       @RequestBody Todo todo){
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();  // 204 的语义是“请求成功，但服务器没有返回任何内容”
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TodoNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());    // NOT_FOUND代表的是404
    }
}
