package app.service.intefaces;

import app.model.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image saveImage(MultipartFile file);
    byte[] downloadImage(Long id);
    List<Image> getAllImages();
}
