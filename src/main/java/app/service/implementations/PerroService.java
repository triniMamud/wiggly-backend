package app.service.implementations;

import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.Perro;
import app.repository.IPerrosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IPerroService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO, Perro> implements IPerroService {

    public PerroService(IPerrosRepository repository) {
        super(repository);
    }

    @Override
    public MascotaDTO altaPerro(MascotaDTO mascota) throws Exception {
        addMascota(mascota, Perro.class);
        return mascota;
    }

    @Override
    public List<MascotaDTO> getPerrosList() throws MessagingException {
        return getListMascotas(PerroDTO.class);
    }
    @Override
    public MascotaDTO editPerro(int idPerro, MascotaDTO mascotaDTO) throws Exception {
        return editMascota(idPerro, mascotaDTO, PerroDTO.class);
    }
}
