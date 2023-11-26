package app.service.common;

import app.exception.types.DeleteEntityException;
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



    /*public List<ItemDTO> getMyPets(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPetRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(myPet.getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(pet.getPetId()).get(), ItemDTO.class)));
        return itemPetList;
    }*/

    public boolean addToMyPets(long idPet, String email) {
        return isNotEmpty(myPetRepository.save(MyPet.builder().petId(idPet).email(email).build()));
    }

    /*public List<AdoptantDTO> getAdoptantsPet(int idPet) {
        List<AdoptantDTO> adoptantDTOS = new ArrayList<>();
        adoptantRepository.findAll().stream()
                //.filter(adoptant -> adoptant.getPet() == idPet)
                .forEach(adoptant -> {
                    User user = usersRepository.findById(adoptant.getUser()).get();
                    adoptantDTOS.add(new AdoptantDTO(user.getName(), user.getLastName(), user.getNeighbourhood(), user.getHouseType()));
                });
        return adoptantDTOS;
    }*/

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
            List<String> petBytesImages = new ArrayList<>();
            petImageService.getAllByIdPet(myPet.getPetId()).forEach(petImage -> {
                petBytesImages.add(petImage.getImageFilename());
            });
            petResponseList.add(new MyPetResponseDTO(modelMapper.map(petRepository.findById(myPet.getPetId()), ItemDTO.class), petBytesImages));
        });
        return petResponseList;
    }


//        Specification<Pet> spec = Specification.where(null);
//
//        spec = addConditionIfPresent(spec, Optional.ofNullable(searchParameters.getGender()), "gender", (root, criteriaBuilder, value) ->
//                criteriaBuilder.equal(root.get("gender"), value));
//
//        Optional<Integer> minAge = Optional.of(searchParameters.getMinAge());
//        Optional<Integer> maxAge = Optional.of(searchParameters.getMaxAge());
//
//        spec = addConditionIfPresent(spec, minAge, "age", (root, criteriaBuilder, value) ->
//                criteriaBuilder.greaterThanOrEqualTo(root.get("age"), value));
//
//        spec = addConditionIfPresent(spec, maxAge, "age", (root, criteriaBuilder, value) ->
//                criteriaBuilder.lessThanOrEqualTo(root.get("age"), value));
//
//        spec = addConditionIfNotEmpty(spec, searchParameters.getNeighbourhood(), "neighbourhood", (root, criteriaBuilder, value) ->
//                criteriaBuilder.equal(root.get("neighbourhood"), value));
//
//        List<Pet> pets = petRepository.findAll(spec);
//
//        return pets;
//    }
//
//    private <T> Specification<T> addConditionIfPresent(Specification<T> spec, Optional<T> value, String fieldName,
//                                                       TriFunction<Root<Pet>, CriteriaBuilder, T, Predicate> condition) {
//        return value.map(v -> spec.and((root, query, criteriaBuilder) -> condition.apply(root, criteriaBuilder, v)))
//                .orElse(spec);
//    }
//
//    private <T> Specification<T> addConditionIfNotEmpty(Specification<T> spec, String value, String fieldName,
//                                                        TriFunction<Root<T>, CriteriaBuilder, String, Predicate> condition) {
//        return StringUtils.isNotEmpty(value)
//                ? spec.and((root, query, criteriaBuilder) -> condition.apply(root, criteriaBuilder, value))
//                : spec;
//    }
//
//    @FunctionalInterface
//    private interface TriFunction<T, U, V, R> {
//        R apply(T t, U u, V v);
//    }
}
