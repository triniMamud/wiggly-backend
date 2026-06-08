package app.service.common;

import app.model.entity.PetImage;
import app.repository.IPetImageRepository;
import app.repository.IPetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetImageService {

    private final IPetImageRepository petImageRepository;
    private final IPetRepository petRepository;
    private final ImageService imageService;

    public List<PetImage> getAllByIdPet(long petId) {
        return petImageRepository.findBypetId(petId);
    }

    public PetImage savePetImage(String imagePath, String imageFilename, long petId) {
        return petImageRepository.save(PetImage.builder().imagePath("data:image;base64,"+imagePath).imageFilename(imageFilename).petId(petId).build());
    }

    @Transactional
    public void deletePetImage(long petId){
        petRepository.findById(petId).get().getPetImageIds().forEach( petImageId -> {
                petImageRepository.deleteById(petImageId);
                imageService.deleteImageS3(petImageId);
        });
    }
}
