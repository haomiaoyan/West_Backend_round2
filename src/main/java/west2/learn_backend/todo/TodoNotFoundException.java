package west2.learn_backend.todo;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String id){
        super("ToDo Not Found:" + id);
    }
}
