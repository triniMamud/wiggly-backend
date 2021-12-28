package app.service.intefaces;

import app.model.entity.Todo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITodoService {
    Todo saveTodo(MultipartFile file);

    byte[] downloadTodoImage(Long id);

    List<Todo> getAllTodos();
}
