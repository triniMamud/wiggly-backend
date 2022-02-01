package app.service.common;

import app.model.MyPets;
import app.model.dto.ItemDTO;
import app.model.entity.MyPostulations;
import app.repository.IMyPostulationsRepository;
import app.repository.IUsersRepository;
import app.service.intefaces.IMyPostulationsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class MyPostulationsPetCommonService <T extends JpaRepository> implements IMyPostulationsService {

    private final IMyPostulationsRepository myPostulationsRepository;
    private final T petRepository;

    private ModelMapper mapper = new ModelMapper();


    @Autowired
    public MyPostulationsPetCommonService(IMyPostulationsRepository myPostulationsRepository, T petRepository) {
        this.myPostulationsRepository = myPostulationsRepository;
        this.petRepository = petRepository;
    }

    @Override
    public List<ItemDTO> getMyPostulations(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPostulationsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPets.class.cast(myPet).getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(MyPostulations.class.cast(pet).getPet()).get(), ItemDTO.class))
                );
        return itemPetList;
    }
}
