package app.service.implementations;

import app.config.BucketName;
import app.model.entity.Image;
import app.repository.IImageRepository;
import app.service.FileStore;
import app.service.intefaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class ImageService implements IImageService {
    private final FileStore fileStore;
    private final IImageRepository repository;

    @Override
    public Image saveTodo(MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        Image image = Image.builder()
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        repository.save(image);
        return repository.findById(image.getId()).get();
    }

    @Override
    public byte[] downloadTodoImage(Long id) {
        Image image = repository.findById(id).get();
        return fileStore.download(image.getImagePath(), image.getImageFileName());
    }

    @Override
    public List<Image> getAllTodos() {
        List<Image> images = new ArrayList<>();
        repository.findAll().forEach(images::add);
        return images;
    }
}
