package app.service;

import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PerroService extends CommonService<IPerrosRepository, PerroDTO> implements IPerroService {

    @Autowired
    NotificationService notificationService;

    @Override
    public List<MascotaDTO> getList() throws MessagingException {
        notificationService.sendNotification();
        return getListMascotas(PerroDTO.class);
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota) {
        addMascota(mascota, PerroDTO.class);
        return mascota;
    }
}
