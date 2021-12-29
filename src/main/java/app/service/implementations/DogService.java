package app.service.implementations;

import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.dto.DogDTO;
import app.model.entity.PetImageDog;
import app.repository.IImageDogRepository;
import app.model.entity.Dog;
import app.repository.IDogsRepository;
import app.service.common.CommonService;
import app.service.intefaces.IDogService;
import app.service.intefaces.IImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService extends CommonService<IDogsRepository, DogDTO, Dog, IImageDogRepository, PetImageDog> implements IDogService {

    public DogService(IDogsRepository repository, IImageService todoService, IImageDogRepository imageDogRepository) {
        super(repository, todoService, imageDogRepository);
    }

    @Override
    public List<PetDTOResponse> getList() {
        return getListMascotas(DogDTO.class);
    }
    @Override
    public PetDTOResponse altaMascota(PetDTORequest mascota) throws Exception {
        return addMascota(mascota, Dog.class, PetImageDog.class);
    }

    @Override
    public PetDTO editPerro(int idPerro, PetDTO petDTO) throws Exception {
        return editMascota(idPerro, petDTO, DogDTO.class);
    }
}
