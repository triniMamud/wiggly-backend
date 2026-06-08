package app.service.common;

import app.model.dto.FavouritePetDTO;
import app.model.dto.ItemDTO;
import app.model.dto.PetDTO;
import app.model.dto.response.MyFavPetResponse;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.model.dto.response.PetDTOResponse;
import app.model.entity.FavouritePet;
import app.model.entity.Pet;
import app.repository.IFavouritePetRepository;
import app.repository.IPetRepository;
import app.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@AllArgsConstructor
public class FavouritePetService {

    private final IPetRepository petRepository;
    private final IFavouritePetRepository favouriteRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PetImageService petImageService;


    /*public List<ItemDTO> getFavouriteItemsByUsername(String username) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteRepository.findAll()
                .parallelStream().filter(favouritePet ->  favouritePet.getUsername().equalsIgnoreCase(username))
                .forEach(favPetUser -> favourites.add(mapper.map(petRepository.findById(favPetUser.getIdPet()), ItemDTO.class)));
        return favourites;
    }*/

    public FavouritePetDTO save(String email, Long petId) {
        FavouritePet favouritePetToSave = FavouritePet.builder()
                .email(email)
                .petId(petId)
                .build();

        petRepository.updateFav(petId, true);

        return modelMapper.map(favouriteRepository.save(favouritePetToSave), FavouritePetDTO.class);

    }

    @Transactional
    public void deleteFavPet(String email, long id) {
        favouriteRepository.deleteByEmailAndIdPet(email, id);

        boolean stillFavoured = favouriteRepository.existsByPetId(id);
        if (!stillFavoured) {
            petRepository.updateFav(id, false);
        }
    }

    public List<MyFavPetResponse> getFavouritePetByUser(String email) {
        Optional<List<FavouritePet>> favoritesOptional = favouriteRepository.findByEmail(email);

        if (favoritesOptional.isPresent()) {
            return favoritesOptional.get().stream().map(favPet -> {
                Pet pet = petRepository.findById(favPet.getPetId()).orElse(null);
                if (pet == null) return null;

                List<String> images = new ArrayList<>();
                petImageService.getAllByIdPet(favPet.getPetId()).forEach(petImage ->
                        images.add(petImage.getImageFilename())
                );

                return MyFavPetResponse.builder()
                        .idPet(pet.getId())
                        .name(pet.getName())
                        .gender(pet.getGender())
                        .location(pet.getLocation())
                        .age(pet.getAge())
                        .images(images)
                        .shelterName(null)
                        .build();
            }).filter(Objects::nonNull).toList();
        }
        return emptyList();
    }
}
