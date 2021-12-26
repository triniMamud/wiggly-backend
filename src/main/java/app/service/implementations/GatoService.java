package app.service.implementations;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import app.service.CommonService;
import app.service.intefaces.IGatoService;
import app.service.intefaces.IPerroService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class GatoService extends CommonService<IGatosRepository, GatoDTO> implements IGatoService {

    @Override
    public List<MascotaDTO> getList() throws MessagingException {
        return getListMascotas(GatoDTO.class);
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota) {
        addMascota(mascota, GatoDTO.class);
        return mascota;
    }
}
