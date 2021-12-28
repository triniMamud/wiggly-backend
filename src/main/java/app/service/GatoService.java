package app.service;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.Gato;
import app.model.entity.Perro;
import app.repository.IGatosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.util.List;

public class GatoService extends CommonService<IGatosRepository, GatoDTO, Gato> implements IGatoService {

    @Autowired
    NotificationService notificationService;

    @Override
    public MascotaDTO altaGato(MascotaDTO mascota) throws Exception {
        addMascota(mascota, Gato.class);
        return mascota;
    }

    @Override
    public List<MascotaDTO> getGatosList() throws MessagingException {
        notificationService.sendNotification();
        return getListMascotas(GatoDTO.class);
    }

    @Override
    public MascotaDTO editCat(int idPerro, MascotaDTO mascotaDTO) throws Exception {
        return editMascota(idPerro, mascotaDTO, GatoDTO.class);
    }
}
