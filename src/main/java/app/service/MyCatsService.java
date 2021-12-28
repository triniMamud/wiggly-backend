package app.service;

import app.model.dto.ItemDTO;
import app.model.dto.PostulantesDTO;
import app.model.entity.MyCats;
import app.model.entity.MyDogs;
import app.repository.IAdoptantsCatRepository;
import app.repository.IAdoptantsDogRepository;
import app.repository.IGatosRepository;
import app.repository.IMyCatsRepository;
import app.repository.IMyDogsRepository;
import app.repository.IPerrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCatsService extends  MyPetsCommonService<IMyCatsRepository, IGatosRepository, IAdoptantsCatRepository, MyCats> implements IMyCatsService {

    @Override
    public List<ItemDTO> getMyCats(String username) {
        return getMyPets(username);
    }

    @Override
    public void addToMyCatss(int idCat, String username) throws Exception {
        addToMyPets(idCat, username, MyCats.class);
    }

    @Override
    public List<PostulantesDTO> getAdoptantsCat(int idCat) {
        return getPostulantesPet(idCat);
    }
}
