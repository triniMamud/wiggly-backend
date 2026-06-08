package app.service.common;

import app.exception.types.DeleteEntityException;
import app.exception.types.EntityNotFoundException;
import app.model.dto.*;
import app.model.dto.request.MyPetsSearchRequestParameters;
import app.model.dto.response.MyPetResponseDTO;
import app.model.dto.response.PetDTOResponse;
import app.model.entity.MyPet;
import app.model.entity.Pet;
import app.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ObjectUtils.*;


@Service
@AllArgsConstructor
public class MyPetsService {

    private final IMyPetRepository myPetRepository;
    private final IPetRepository petRepository;
    private final IAdoptantRepository adoptantRepository;
    private final IUserRepository usersRepository;
    private final PetImageService petImageService;
    private final ImageService imageService;
    private final ModelMapper modelMapper;
    private final IFavouritePetRepository favouritePetRepository;
    private final IMyPostulationsRepository myPostulationsRepository;

    public boolean addToMyPets(long idPet, String email) {
        return isNotEmpty(myPetRepository.save(MyPet.builder().petId(idPet).email(email).build()));
    }

    @Transactional
    public List<ItemDTO> searchMyPets(MyPetsSearchRequestParameters searchParameters) {
        Specification<Pet> spec = Specification.where(null);

        if (isNotEmpty(searchParameters.getType()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("type"), searchParameters.getGender()));

        if (isNotEmpty(searchParameters.getSize()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("size"), searchParameters.getSize()));

        if (nonNull(searchParameters.getAge()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("age"), searchParameters.getAge()));

        if (isNotEmpty(searchParameters.getGender()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("gender"), searchParameters.getGender()));

        if (isNotEmpty(searchParameters.getLocation()))
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("location"), searchParameters.getLocation()));

        List<Pet> pets = myPetRepository.findAll(spec);
        return pets.stream().map(pet -> modelMapper.map(pet, ItemDTO.class)).collect(toList());
    }

    public void deleteFromMyPets(String email, long petId) throws DeleteEntityException {
        myPetRepository.deleteByEmailAndIdPet(email, petId);
    }

    public List<MyPetResponseDTO> getMyPets(String email) {
        List<MyPetResponseDTO> petResponseList = new ArrayList<>();

        myPetRepository.getMyPetsByEmail(email).forEach(myPet -> {
            Long petId = myPet.getPetId();

            // Imágenes
            List<String> images = new ArrayList<>();
            petImageService.getAllByIdPet(petId)
                    .forEach(petImage -> images.add(petImage.getImageFilename()));

            // Conteos
            int favCount = favouritePetRepository.countByPetId(petId);
            int postulationsCount = myPostulationsRepository.countByPetId(petId);

            // Mapeo manual al nuevo DTO
            petRepository.findById(petId).ifPresent(pet -> {
                MyPetItemDTO itemDTO = new MyPetItemDTO(
                        Math.toIntExact(pet.getId()),
                        pet.getName(),
                        pet.getLocation(),
                        pet.getGender(),
                        pet.getAge(),
                        favCount,
                        postulationsCount
                );
                petResponseList.add(new MyPetResponseDTO(itemDTO, images));
            });
        });

        return petResponseList;
    }

    public Optional<String> findSheltarNameByPetId(Long petId) {
        return myPetRepository
                .findFirstByPetId(petId)
                .map(MyPet::getEmail);
    }
}
