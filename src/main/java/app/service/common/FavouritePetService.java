package app.service.common;

import app.model.dto.FavouritePetDTO;
import app.model.dto.ItemDTO;
import app.model.dto.PetDTO;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.model.dto.response.PetDTOResponse;
import app.model.entity.FavouritePet;
import app.repository.IFavouritePetRepository;
import app.repository.IPetRepository;
import app.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        FavouritePet favouritePetToSave = FavouritePet.builder().email(email).petId(petId).build();

        return modelMapper.map(favouriteRepository.save(favouritePetToSave), FavouritePetDTO.class);
    }

    @Transactional
    public void delete(String email, long id) {
        favouriteRepository.deleteByEmailAndIdPet(email, id);
    }

    public void deleteFavouritePet(String email, long idPet) {
        favouriteRepository.deleteByEmailAndIdPet(email, idPet);
    }

    public List<PetDTOResponse> getFavouritePetByUser(String email) {
        Optional<List<FavouritePet>> favoritesOptional = favouriteRepository.findByEmail(email);

        if (favoritesOptional.isPresent()) {
            return favoritesOptional.get().stream().map(favPet -> {
                PetDTO petItem = modelMapper.map(petRepository.findById(favPet.getPetId()).orElse(null), PetDTO.class);
                List<String> petBytesImages = new ArrayList<>();

                petImageService.getAllByIdPet(favPet.getPetId()).forEach(petImage ->
                        petBytesImages.add(petImage.getImageFilename())
                );
                return new PetDTOResponse(petItem, petBytesImages);
            }).toList();
        } else {
            return emptyList();
        }
    }
}
