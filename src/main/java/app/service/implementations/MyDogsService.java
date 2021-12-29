package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.dto.AdoptantDTO;
import app.model.entity.MyDogs;
import app.repository.IAdoptantsDogRepository;
import app.repository.IMyDogsRepository;
import app.repository.IDogsRepository;
import app.service.common.MyPetsCommonService;
import app.service.intefaces.IMyDogsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDogsService extends MyPetsCommonService<IMyDogsRepository, IDogsRepository, IAdoptantsDogRepository, MyDogs> implements IMyDogsService {

    @Override
    public List<ItemDTO> getMyDogs(String username) {
        return getMyPets(username);
    }

    @Override
    public void addToMyDogs(int idDog, String username) throws Exception {
        addToMyPets(idDog, username, MyDogs.class);
    }

    @Override
    public List<AdoptantDTO> getAdoptantsDog(int idDog) {
        return getPostulantesPet(idDog);
    }
}
