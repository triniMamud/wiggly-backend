package app.service.common;

import app.model.entity.FavouritePet;
import app.model.entity.Pet;
import app.repository.IFavouritePetRepository;
import app.repository.IPetRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Service
@AllArgsConstructor
public class FavouritePetService {

    private final IPetRepository petRepository;
    private final IFavouritePetRepository favouriteRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;



    /*public List<ItemDTO> getFavouriteItemsByUsername(String username) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteRepository.findAll()
                .parallelStream().filter(favouritePet ->  favouritePet.getUsername().equalsIgnoreCase(username))
                .forEach(favPetUser -> favourites.add(mapper.map(petRepository.findById(favPetUser.getIdPet()), ItemDTO.class)));
        return favourites;
    }*/

    public Boolean addFavouritePet(String email, long idPet) {
        FavouritePet favouritePet = favouriteRepository.findByUser(email).orElse(FavouritePet.builder().userEmail(email).build());
        favouritePet.getPetIds().add(idPet);
        return isNotEmpty(favouriteRepository.save(favouritePet));
    }

    public void deleteFavouritePet(String email, long idPet) {
       favouriteRepository.deleteByEmailAndIdPet(email, idPet);
    }

}
