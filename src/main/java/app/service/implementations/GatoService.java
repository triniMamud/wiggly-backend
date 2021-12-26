package app.service.implementations;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.repository.IGatosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IGatoService;
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
