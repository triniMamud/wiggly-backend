package app.service.common;

import app.config.BucketName;
import app.model.entity.HouseImage;
import app.model.entity.PetImage;
import app.repository.IPetImageRepository;
import app.service.FileStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.apache.http.entity.ContentType.IMAGE_BMP;
import static org.apache.http.entity.ContentType.IMAGE_GIF;
import static org.apache.http.entity.ContentType.IMAGE_JPEG;
import static org.apache.http.entity.ContentType.IMAGE_PNG;

@Service
@AllArgsConstructor
public class ImageService {

    private final FileStore fileStore;
    private final IPetImageRepository petImageRepository;

//    public PetImage saveImageS3(MultipartFile file) {
//        //check if the file is empty
//        if (file.isEmpty()) {
//            throw new IllegalStateException("Cannot upload empty file");
//        }
//        //Check if the file is an image
//        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
//                IMAGE_BMP.getMimeType(),
//                IMAGE_GIF.getMimeType(),
//                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
//            throw new IllegalStateException("FIle uploaded is not an image");
//        }
//        //get file metadata
//        Map<String, String> metadata = new HashMap<>();
//        metadata.put("Content-Type", file.getContentType());
//        metadata.put("Content-Length", String.valueOf(file.getSize()));
//        //Save Image in S3 and then save Todo in the database
//        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
//        String fileName = String.format("%s", file.getOriginalFilename());
//        try {
//            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
//        } catch (IOException e) {
//            throw new IllegalStateException("Failed to upload file", e);
//        }
//        return PetImage.builder().imagePath("data:image;base64,"+path).imageFilename(fileName).build();
//    }

//    public HouseImage saveHouseImageS3(MultipartFile file) {
//        //check if the file is empty
//        if (file.isEmpty()) {
//            throw new IllegalStateException("Cannot upload empty file");
//        }
//        //Check if the file is an image
//        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
//                IMAGE_BMP.getMimeType(),
//                IMAGE_GIF.getMimeType(),
//                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
//            throw new IllegalStateException("FIle uploaded is not an image");
//        }
//        //get file metadata
//        Map<String, String> metadata = new HashMap<>();
//        metadata.put("Content-Type", file.getContentType());
//        metadata.put("Content-Length", String.valueOf(file.getSize()));
//        //Save Image in S3 and then save Todo in the database
//        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
//        String fileName = String.format("%s", file.getOriginalFilename());
//        try {
//            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
//        } catch (IOException e) {
//            throw new IllegalStateException("Failed to upload file", e);
//        }
//        return HouseImage.builder().imagePath("data:image;base64,"+path).imageFilename(fileName).build();
//    }

    public byte[] downloadImage(String imagePath, String imageFilename) {
        return fileStore.download(imagePath, imageFilename);
    }

    public void deleteImageS3 (long id) {
        PetImage image = petImageRepository.findById(id).get();
        fileStore.delete(image.getImagePath(), image.getImageFilename());
    }

    /*public List<PetImage> getAllImages() {
        List<PetImage> images = new ArrayList<>();
        imageRepository.findAll().forEach(images::add);
        return images;
    }*/
}
