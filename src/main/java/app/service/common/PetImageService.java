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
        return petImageRepository.findByid(petId);
    }

    public PetImage savePetImage(String imagePath, String imageFilename) {
        return petImageRepository.save(PetImage.builder().imagePath(imagePath).imageFilename(imageFilename).build());
    }

    @Transactional
    public void deletePetImage(long petId){
        petRepository.findById(petId).get().getPetImageIds().forEach( petImageId -> {
                petImageRepository.deleteById(petImageId);
                imageService.deleteImageS3(petImageId);
        });
    }
}
