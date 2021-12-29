package app.service.implementations;

import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;
import app.model.entity.MyCats;
import app.repository.IAdoptantsCatRepository;
import app.repository.ICatsRepository;
import app.repository.IMyCatsRepository;
import app.repository.IUsersRepository;
import app.service.common.MyPetsCommonService;
import app.service.intefaces.IMyCatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCatsService extends MyPetsCommonService<IMyCatsRepository, ICatsRepository, IAdoptantsCatRepository, MyCats> implements IMyCatsService {

    public MyCatsService(IMyCatsRepository myPetsRepository, ICatsRepository petRepository, IAdoptantsCatRepository adoptantsRepository, IUsersRepository usersRepository) {
        super(myPetsRepository, petRepository, adoptantsRepository, usersRepository);
    }

    @Override
    public List<ItemDTO> getMyCats(String username) {
        return getMyPets(username);
    }

    @Override
    public void addToMyCats(int idCat, String username) throws Exception {
        addToMyPets(idCat, username, MyCats.class);
    }

    @Override
    public List<AdoptantDTO> getAdoptantsCat(int idCat) {
        return getAdoptantsPet(idCat);
    }
}
