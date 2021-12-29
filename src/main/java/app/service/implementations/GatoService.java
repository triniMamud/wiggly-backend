package app.service.implementations;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.MascotaDTORequest;
import app.model.dto.MascotaDTOResponse;
import app.model.entity.ImageCat;
import app.repository.IGatosRepository;
import app.repository.IImageCatRepository;
import app.repository.IImageDogRepository;
import app.service.common.CommonService;
import app.service.intefaces.IGatoService;
import app.service.intefaces.ITodoService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class GatoService extends CommonService<IGatosRepository, GatoDTO, IImageCatRepository, ImageCat> implements IGatoService {

    public GatoService(IGatosRepository repository, ITodoService todoService, IImageCatRepository imageCatRepository) {
        super(repository, todoService,imageCatRepository);
    }

    @Override
    public List<MascotaDTOResponse> getList() {
        return getListMascotas(GatoDTO.class);
    }

    @Override
    public MascotaDTOResponse altaMascota(MascotaDTORequest mascota) {
        return addMascota(mascota, GatoDTO.class, ImageCat.class);
    }
}
