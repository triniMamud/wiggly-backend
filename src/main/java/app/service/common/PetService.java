package app.service.common;

import app.exception.types.DeleteEntityException;
import app.exception.types.EntityNotFoundException;
import app.exception.types.ImagesNotSavedException;
import app.exception.types.SavePetException;
import app.model.dto.*;
import app.model.dto.request.PetDTORequest;
import app.model.dto.request.PetsSearchRequestParameters;
import app.model.dto.request.UpdatePetRequest;
import app.model.dto.response.PetDTOResponse;
import app.model.entity.Pet;
import app.model.entity.PetImage;
import app.model.enums.AgeEnum;
import app.repository.IPetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static app.model.enums.AgeEnum.*;
import static app.service.Base64DecodedMultipartFile.base64ToMultipart;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@AllArgsConstructor
@Service
public class PetService {

    private final IPetRepository petRepository;
    private final PetImageService petImageService;
    private final ImageService imageService;
    private final MyPetsService myPetsService;
    private final FavouritePetService favouritePetService;
    private final AdoptantService adoptantService;
    private final MyPostulationsService myPostulationsService;
    private final ModelMapper modelMapper;


    @Transactional
    public boolean addNewPet(PetDTORequest petRequest, String email) throws Exception {
        try {
            Pet pet = modelMapper.map(petRequest.getPet(), Pet.class);
            pet.setAgeEnum(this.getAge(pet.getAge()));
            long petId = petRepository.save(modelMapper.map(petRequest.getPet(), Pet.class)).getId();
            pet.setPetImageIds(saveImages(petRequest.getImages(), petId).stream().map(PetImage::getId).collect(Collectors.toSet()));
            myPetsService.addToMyPets(petId, email);
            return true;
        } catch (Exception e) {
            throw new Exception("No se pudo dar de alta la mascota");
        }
    }

    @Transactional
    public List<PetDTO> search(PetsSearchRequestParameters searchParameters) {
        Specification<Pet> spec = Specification.where(null);

        if (nonNull(searchParameters.getType()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("type"), searchParameters.getType()));

        if (isNotBlank(searchParameters.getSize()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("size"), searchParameters.getSize()));

        if (nonNull(searchParameters.getAgeEnum()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("ageEnum"), searchParameters.getAgeEnum()));

        if (isNotBlank(searchParameters.getGender()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("gender"), searchParameters.getGender()));

        List<Pet> pets = petRepository.findAll(spec);
        return pets.stream().map(pet -> modelMapper.map(pet, PetDTO.class)).collect(toList());
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

    public List<PetDTOResponse> getListPets() {
        List<PetDTOResponse> petResponseList = new ArrayList<>();
        petRepository.findAll().forEach(pet -> {
            List<byte[]> petBytesImages = new ArrayList<>();
            petImageService.getAllByIdPet(pet.getId()).forEach(petImage ->
                    petBytesImages.add(imageService.downloadImage(petImage.getImagePath(), petImage.getImageFilename())));
            petResponseList.add(new PetDTOResponse(modelMapper.map(pet, PetDTO.class), petBytesImages));
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

    /*public PetDTOResponse getPet(int idPet) {
        List<byte[]> petBytesImages = petImageService.findAllByidPet(idPet).stream()
                .map(petImage -> imageService.downloadImage(petImage.getIdImage())).collect(toList());

        return PetDTOResponse.builder().pet(mapper.map(petRepository.findById(idPet), PetDTO.class)).images(petBytesImages).build();
    }*/

    public List<PetImage> saveImages(List<String> images, long petId) {
        return images.stream().map(imgString64 -> {
            try {
                PetImage image  = imageService.saveImageS3(base64ToMultipart(imgString64));
                var pet = petImageService.savePetImage(image.getImagePath(), image.getImageFilename(), petId);
                return pet;
//                return imageService.downloadImage(image.getImagePath(), image.getImageFilename());
            } catch (Exception e) {
                throw new RuntimeException();
            }
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
        if(age <= 1.5F) {
            return PUPPY;
        }
        else if(age > 9) {
            return ELDER;
        }

        return ADULT;
    }

}