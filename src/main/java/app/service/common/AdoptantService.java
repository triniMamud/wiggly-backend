package app.service.common;

import app.model.dto.AdoptantDTO;
import app.model.entity.Adoptant;
import app.repository.IAdoptantRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdoptantService {

    private final IAdoptantRepository adoptantRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    public AdoptantDTO save(String email, Long petId) {
        Adoptant adoptantToSave = Adoptant.builder().email(email).petId(petId).build();

        return modelMapper.map(adoptantRepository.save(adoptantToSave), AdoptantDTO.class);
    }

    public void deletePetFromAdoptant(String email, long petId) {
        adoptantRepository.deleteByEmailAndPetId(email, petId);
    }

    public void delete(Long id) {
        adoptantRepository.deleteById(id);
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
