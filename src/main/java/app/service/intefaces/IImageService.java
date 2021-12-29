package app.service.intefaces;

import app.model.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image saveTodo(MultipartFile file);

    byte[] downloadTodoImage(Long id);

    List<Image> getAllTodos();
}
