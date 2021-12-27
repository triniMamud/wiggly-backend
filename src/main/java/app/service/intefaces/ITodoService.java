package app.service.intefaces;

import app.model.entity.Todo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITodoService {
    Todo saveTodo(String title, String description, MultipartFile file);

    byte[] downloadTodoImage(Long id);

    List<Todo> getAllTodos();
}
