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

    public HouseImage saveImages(String imagePath, String imageFilename, String email) {
        return houseImageRepository.save(HouseImage.builder().imagePath("data:image;base64,"+imagePath).imageFilename(imageFilename).email(email).build());
    }

    private HouseImage saveHouseImage(String imagePath, String imageFilename, String email) {
        return houseImageRepository.save(HouseImage.builder().imagePath("data:image;base64,"+imagePath).imageFilename(imageFilename).email(email).build());
    }

}
