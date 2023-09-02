package app.service.common;

import app.model.entity.MyPostulations;
import app.model.enums.PostulationStatusEnum;
import app.repository.IMyPostulationsRepository;
import app.repository.IPetRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@AllArgsConstructor
@Service
public class MyPostulationsService {

    private final IMyPostulationsRepository myPostulationsRepository;
    private final IPetRepository petRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;


    /*public List<ItemDTO> getMyPostulations(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPostulationsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPet.class.cast(myPet).getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(MyPostulation.class.cast(pet).getPet()).get(), ItemDTO.class))
                );
        return itemPetList;
    }*/

    public boolean postulate(String email, long idPet) {
        MyPostulations myPostulations = myPostulationsRepository.findByEmail(email).orElse(MyPostulations.builder().email(email).build());
        myPostulations.getPetIds().add(idPet);
        myPostulations.setStatus(PostulationStatusEnum.SENT);
        return isNotEmpty(myPostulationsRepository.save(myPostulations));
    }

    public void deletePetFromPostulations(String email, long petId) {
        myPostulationsRepository.deleteByEmailAndIdPet(email, petId);
    }
}
