package west2.learn_backend.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    void save(Todo t);  // 更新一条
    Optional<Todo> findById(String id);   // 按id寻找
    List<Todo> findAll();   //  查找全部
    void deleteById(String id);   //  根据id进行删除删除
}
