package app.service.implementations;

import app.model.dto.CatDTO;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.entity.PetImageCat;
import app.model.entity.Cat;
import app.repository.ICatsRepository;
import app.repository.IImageCatRepository;
import app.service.common.CommonService;
import app.service.intefaces.ICatService;
import app.service.intefaces.IImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService extends CommonService<ICatsRepository, CatDTO, Cat, IImageCatRepository, PetImageCat> implements ICatService {

    public CatService(ICatsRepository repository, IImageService todoService, IImageCatRepository imageCatRepository) {
        super(repository, todoService,imageCatRepository);
    }

    @Override
    public List<PetDTOResponse> getCatsList() {
        return getListMascotas(CatDTO.class);
    }

    @Override
    public PetDTOResponse addNewCat(PetDTORequest mascota) throws Exception {
        return addMascota(mascota, Cat.class, PetImageCat.class);
    }

    @Override
    public PetDTO editCat(int idCat, PetDTO petDTO) throws Exception {
        return editMascota(idCat, petDTO, CatDTO.class);
    }
}
