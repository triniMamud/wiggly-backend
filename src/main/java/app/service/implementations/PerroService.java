package app.service.implementations;

import app.model.dto.MascotaDTORequest;
import app.model.dto.MascotaDTOResponse;
import app.model.dto.PerroDTO;
import app.model.entity.ImageDog;
import app.repository.IImageDogRepository;
import app.repository.IPerrosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IPerroService;
import app.service.intefaces.ITodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO, IImageDogRepository, ImageDog> implements IPerroService {

    public PerroService(IPerrosRepository repository, ITodoService todoService, IImageDogRepository imageDogRepository) {
        super(repository, todoService, imageDogRepository);
    }

    @Override
    public List<MascotaDTOResponse> getList() {
        return getListMascotas(PerroDTO.class);
    }

    @Override
    public MascotaDTOResponse altaMascota(MascotaDTORequest mascota) {
        return addMascota(mascota, PerroDTO.class, ImageDog.class);
    }
}
