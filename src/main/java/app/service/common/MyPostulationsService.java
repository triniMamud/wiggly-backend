package app.service.common;

import app.model.entity.MyPostulation;
import app.model.entity.Pet;
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
        MyPostulation myPostulation = myPostulationsRepository.findByUser(email).orElse(MyPostulation.builder().userEmail(email).build());
        myPostulation.getPetIds().add(idPet);
        myPostulation.setStatus(PostulationStatusEnum.SENT);
        return isNotEmpty(myPostulationsRepository.save(myPostulation));
    }

    public void deletePetFromPostulations(String email, long petId) {
        myPostulationsRepository.deleteByEmailAndIdPet(email, petId);
    }
}
