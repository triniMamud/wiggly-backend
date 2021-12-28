package app.service;

import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.Perro;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO, Perro> implements IPerroService {

    @Autowired
    NotificationService notificationService;

    @Override
    public MascotaDTO altaPerro(MascotaDTO mascota) throws Exception {
        addMascota(mascota, Perro.class);
        return mascota;
    }

    @Override
    public List<MascotaDTO> getPerrosList() throws MessagingException {
        notificationService.sendNotification();
        return getListMascotas(PerroDTO.class);
    }

    @Override
    public MascotaDTO editPerro(int idPerro, MascotaDTO mascotaDTO) throws Exception {
        return editMascota(idPerro, mascotaDTO, PerroDTO.class);
    }
}
