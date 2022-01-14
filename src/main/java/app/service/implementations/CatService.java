package app.service.implementations;

import app.model.dto.CatDTO;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.entity.Cat;
import app.model.entity.PetImageCat;
import app.repository.ICatsRepository;
import app.repository.IImageCatRepository;
import app.service.common.CommonService;
import app.service.intefaces.ICatService;
import app.service.intefaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService extends CommonService<ICatsRepository, CatDTO, Cat, IImageCatRepository, PetImageCat> implements ICatService {

    public CatService(ICatsRepository repository, IImageService todoService, IImageCatRepository imageCatRepository) {
        super(repository, todoService,imageCatRepository);
    }

    @Override
    public List<PetDTOResponse> getCatsList() {
        return getListPets(CatDTO.class);
    }

    @Override
    public PetDTOResponse addNewCat(PetDTORequest petRequest) throws Exception {
        return addNewPet(petRequest, Cat.class, PetImageCat.class);
    }

    @Override
    public PetDTOResponse editCat(int idCat, PetDTORequest petRequest) throws Exception {
        return editPet(idCat, petRequest, CatDTO.class, PetImageCat.class);
    }
}
