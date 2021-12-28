package app.service.implementations;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.entity.Gato;
import app.repository.IGatosRepository;
import app.service.common.CommonService;
import app.service.intefaces.IGatoService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class GatoService extends CommonService<IGatosRepository, GatoDTO, Gato> implements IGatoService {

    public GatoService(IGatosRepository repository) {
        super(repository);
    }

    @Override
    public MascotaDTO altaGato(MascotaDTO mascota) throws Exception {
        addMascota(mascota, Gato.class);
        return mascota;
    }

    @Override
    public List<MascotaDTO> getGatosList() {
        return getListMascotas(GatoDTO.class);
    }

    @Override
    public MascotaDTO editCat(int idPerro, MascotaDTO mascotaDTO) throws Exception {
        return editMascota(idPerro, mascotaDTO, GatoDTO.class);
    }
}
