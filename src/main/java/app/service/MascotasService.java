package app.service;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class MascotasService implements IMascotasService {

    @Autowired
    NotificationService notificationService;

    public List<MascotaDTO> getList(MascotasEnum tipoMascota) throws MessagingException {
        notificationService.sendNotification();
        return tipoMascota.getListMascotas();
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota, MascotasEnum tipoMascota) {
        tipoMascota.altaMascota(mascota);
        return mascota;
    }
}
