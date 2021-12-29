package app.service.implementations;

import app.model.dto.DogDTO;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.entity.Dog;
import app.model.entity.PetImageDog;
import app.repository.IDogsRepository;
import app.repository.IImageDogRepository;
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
    public List<PetDTOResponse> getDogsList() {
        return getListPets(DogDTO.class);
    }
    @Override
    public PetDTOResponse addNewDog(PetDTORequest petRequest) throws Exception {
        return addNewPet(petRequest, Dog.class, PetImageDog.class);
    }

    @Override
    public PetDTO editDog(int idDog, PetDTO petDTO) throws Exception {
        return editPet(idDog, petDTO, DogDTO.class);
    }
}
