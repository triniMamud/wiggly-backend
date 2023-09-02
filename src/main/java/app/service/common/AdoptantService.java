package app.service.common;

import app.repository.IAdoptantRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdoptantService {

    private final IAdoptantRepository adoptantRepository;
    private final IUserRepository userRepository;

    public void deletePetFromAdoptant(String email, long petId) {
        adoptantRepository.deleteByEmailAndPetId(email, petId);
    }

    /*public List<AdoptantDTO> getAllAdoptants(){
        return adoptantRepository.findAll().stream().map(adoptant -> {
            User user = userRepository.findById(adoptant.getUser()).get();
            return new AdoptantDTO(user.getName(), user.getLastName(), user.getNeighbourhood(), user.getHouseType());
        }).collect(toList());

    }*/

    /*public List<AdoptantDTO> getAdoptantsByPet(Integer petId){
        return adoptantRepository.findBypet(petId).stream().map(adoptant -> {
            User user = userRepository.findById(adoptant.getUser()).get();
            return new AdoptantDTO(user.getName(), user.getLastName(), user.getNeighbourhood(), user.getHouseType());
        }).collect(toList());
    }*/
}
