package app.service.common;

import app.model.dto.FavouritePetDTO;
import app.model.entity.FavouritePet;
import app.repository.IFavouritePetRepository;
import app.repository.IPetRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public FavouritePetDTO save(String email, Long petId) {
        FavouritePet favouritePetToSave = FavouritePet.builder().email(email).petId(petId).build();

        return modelMapper.map(favouriteRepository.save(favouritePetToSave), FavouritePetDTO.class);
    }

    public void delete(Long id) {
        favouriteRepository.deleteById(id);
    }

    public void deleteFavouritePet(String email, long idPet) {
       favouriteRepository.deleteByEmailAndIdPet(email, idPet);
    }

}
