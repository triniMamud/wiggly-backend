package app.service.implementations;

import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.ImageDog;
import app.repository.IImageDogRepository;
import app.repository.IPerrosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IPerroService;
import app.service.intefaces.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO, IImageDogRepository, ImageDog> implements IPerroService {

    public PerroService(IPerrosRepository repository, ITodoService todoService, IImageDogRepository imageDogRepository) {
        super(repository, todoService, imageDogRepository);
    }

    @Override
    public List<MascotaDTO> getList() {
        return getListMascotas(PerroDTO.class);
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota) {
        addMascota(mascota, PerroDTO.class, ImageDog.class);
        return mascota;
    }
}
