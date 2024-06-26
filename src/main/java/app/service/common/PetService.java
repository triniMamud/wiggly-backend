package app.service.common;

import app.exception.types.DeleteEntityException;
import app.exception.types.EntityNotFoundException;
import app.exception.types.ImagesNotSavedException;
import app.exception.types.SavePetException;
import app.model.dto.*;
import app.model.dto.request.IsFavPetRequest;
import app.model.dto.request.PetDTORequest;
import app.model.dto.request.UpdatePetRequest;
import app.model.dto.response.PetDTOResponse;
import app.model.entity.Pet;
import app.model.entity.PetImage;
import app.model.enums.AgeEnum;
import app.repository.IPetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static app.model.enums.AgeEnum.*;

@AllArgsConstructor
@Service
public class PetService {

    private final IPetRepository petRepository;
    private final PetImageService petImageService;
    private final MyPetsService myPetsService;
    private final FavouritePetService favouritePetService;
    private final AdoptantService adoptantService;
    private final MyPostulationsService myPostulationsService;
    private final ModelMapper modelMapper;


    @Transactional
    public boolean addNewPet(PetDTORequest petRequest, String email) throws Exception {
        try {
            Pet pet = modelMapper.map(petRequest.getPet(), Pet.class);
            long petId = petRepository.save(pet).getId();
            pet.setPetImageIds(saveImages(petRequest.getImages(), petId).stream().map(PetImage::getId).collect(Collectors.toSet()));
            myPetsService.addToMyPets(petId, email);
            return true;
        } catch (Exception e) {
            throw new Exception("No se pudo dar de alta la mascota");
        }
    }

    @Transactional
    public PetDTO update(Long id, UpdatePetRequest updatePetRequest) {
        Pet petToUpdate = petRepository.findById(id).orElseThrow(RuntimeException::new);
        modelMapper.map(updatePetRequest, petToUpdate);

        if(!updatePetRequest.getImages().isEmpty()) {
            List<PetImage> newPetImages = saveImages(updatePetRequest.getImages(), id);
            petToUpdate.getPetImageIds().addAll(newPetImages.stream().map(PetImage::getId).toList());
        }

        // TODO mappear correctamente a la response que quieras, igual se guarda
        return modelMapper.map(petRepository.save(petToUpdate), PetDTO.class);
    }

    public List<PetDTOResponse> getListPets(String email) {
        List<PetDTOResponse> petResponseList = new ArrayList<>();
        List<Long> favPetIds = favouritePetService.getFavouritePetByUser(email).stream().map(favPet -> (long) favPet.getPet().getId()).toList();
        petRepository.findAll().forEach(pet -> {
            List<String> petBytesImages = new ArrayList<>();
            petImageService.getAllByIdPet(pet.getId()).forEach(petImage ->
                    petBytesImages.add(petImage.getImageFilename()));
            PetDTOResponse petResponse = new PetDTOResponse(modelMapper.map(pet, PetDTO.class), petBytesImages);
            petResponse.getPet().setIsFavPet(favPetIds.contains(pet.getId()));
            petResponseList.add(petResponse);
        });
         return petResponseList;
    }

    @Transactional
    public PetDTOResponse editPet(long idPet, PetDTORequest petRequest) throws EntityNotFoundException, ImagesNotSavedException, SavePetException {
        Pet petDB = petRepository.findById(idPet).orElseThrow(EntityNotFoundException::new);
        try {
            PetDTOResponse petResponse = PetDTOResponse.builder().pet(petRequest.getPet()).build();
            /*if (safeIsNotEmpty(petRequest.getImages())) {
                List<byte[]> img = saveImages(petRequest);
                petResponse.setImages(img);
                PetImage image  = imageService.saveImageS3(multiparFileImg)
                petDB.setPetImageIds();
            }*/ //GUARDAR IMAGENES

            modelMapper.map(petRequest.getPet(), petDB);
            petRepository.save(petDB);

            return petResponse;

        } catch (RuntimeException e) {
            throw new ImagesNotSavedException();
        } catch (Exception e) {
            throw new SavePetException();
        }
    }

    public List<PetImage> saveImages(List<String> images, long petId) {
        return images.stream().map(imgSrc -> {

                //PetImage image  = imageService.saveImageS3(base64ToMultipart(imgString64));
                return petImageService.savePetImage(imgSrc, imgSrc, petId);
//                return imageService.downloadImage(image.getImagePath(), image.getImageFilename());

        }).toList();
    }

    /*public PetImageDTO createImage(PetDTORequest petDTORequest, PetImage image) throws Exception {
        return new PetImageDTO(petDTORequest.getPet().getId(), image.getId());
    }*/

   @Transactional
    public void deletePet(String email, long petId) throws DeleteEntityException {
        try {
            petImageService.deletePetImage(petId);
            favouritePetService.deleteFavouritePet(email, petId);
            adoptantService.deletePetFromAdoptant(email, petId);
            myPostulationsService.deletePetFromPostulations(email, petId);
            myPetsService.deleteFromMyPets(email, petId);
            petRepository.deleteById(petId);
        } catch (Exception e) {
            throw new DeleteEntityException();
        }
    }

    private AgeEnum getAge(float age) {
        if(age <= 1.5F) return PUPPY;
        else if(age > 9) return ELDER;
        return ADULT;
    }

    public void updateFav(Long id, IsFavPetRequest request) {
        petRepository.updateFav(id, request.getIsFavPet());
    }
}