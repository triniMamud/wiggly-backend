package app.service.common;

import app.model.dto.HouseImageDTO;
import app.model.dto.HouseTypeDTO;
import app.model.entity.HouseImage;
import app.model.entity.PetImage;
import app.repository.IHouseImageRepository;
import app.repository.IPetImageRepository;
import app.repository.IPetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static app.service.Base64DecodedMultipartFile.base64ToMultipart;

@Service
@AllArgsConstructor
public class HouseImageService {

    private final IHouseImageRepository houseImageRepository;
    private final IPetRepository petRepository;
    private final ImageService imageService;
    private final ModelMapper modelMapper;

    public List<HouseImage> getAllByEmail(String email) {
        return houseImageRepository.findByEmail(email);
    }

    public List<HouseImage> saveImages(List<String> images, String email) {
        return images.stream().map(imgSrc -> {
            try {
                //HouseImage image  = imageService.saveHouseImageS3(base64ToMultipart(imgString64));
                return this.saveHouseImage(imgSrc, imgSrc, email);
//                return imageService.downloadImage(image.getImagePath(), image.getImageFilename());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }).toList();
    }

    private HouseImage saveHouseImage(String imagePath, String imageFilename, String email) {
        return houseImageRepository.save(HouseImage.builder().imagePath("data:image;base64,"+imagePath).imageFilename(imageFilename).email(email).build());
    }

}
