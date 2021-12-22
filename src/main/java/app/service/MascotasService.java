package app.service;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotasService implements IMascotasService {

    public List<MascotaDTO> getList(MascotasEnum tipoMascota) {
        return tipoMascota.getListMascotas();
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota, MascotasEnum tipoMascota) {
        tipoMascota.altaMascota(mascota);
        return mascota;
    }
}
