package app.service.implementations;

import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;
import app.model.entity.MyDogs;
import app.repository.IAdoptantsDogRepository;
import app.repository.IDogsRepository;
import app.repository.IMyDogsRepository;
import app.repository.IUsersRepository;
import app.service.common.MyPetsCommonService;
import app.service.intefaces.IMyDogsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDogsService extends MyPetsCommonService<IMyDogsRepository, IDogsRepository, IAdoptantsDogRepository, MyDogs> implements IMyDogsService {

    public MyDogsService(IMyDogsRepository myPetsRepository, IDogsRepository petRepository, IAdoptantsDogRepository adoptantsRepository, IUsersRepository usersRepository) {
        super(myPetsRepository, petRepository, adoptantsRepository, usersRepository);
    }

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
        return getAdoptantsPet(idDog);
    }
}
