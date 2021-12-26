package app.service.implementations;

import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.repository.IPerrosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IPerroService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO> implements IPerroService {

    @Override
    public List<MascotaDTO> getList() throws MessagingException {
        return getListMascotas(PerroDTO.class);
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota) {
        addMascota(mascota, PerroDTO.class);
        return mascota;
    }
}
