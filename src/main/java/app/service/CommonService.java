package app.service;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class CommonService<S extends JpaRepository, T extends  MascotaDTO> {

    @Autowired
    S repository;

    public void addMascota(MascotaDTO mascota, Class<T> mascotaType) {
        repository.save(mascotaType.cast(mascota));
    }

    public List<MascotaDTO> getListMascotas(Class<T> mascotaType) {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        repository.findAll()
                .stream()
                .forEach(mascota -> {
                    try {
                        mascotasList.add(cast((Mascota) mascota, mascotaType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return mascotasList;
    }

    public T cast (Mascota mascota, Class<T> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                String.class, String.class, Boolean.class, String.class,
                String.class, String.class, String.class,
                String.class, String.class)
                .newInstance(mascota.getId(), mascota.getNombre(), mascota.getEdadAprox(), mascota.getSexo(),
                        mascota.getTamanio(), mascota.getBarrio(), mascota.getCastrado(), mascota.getVacunas(),
                        mascota.getAclaracionesVacunas(), mascota.getDesparacitado(), mascota.getEnfermedadesYTratamientos(),
                        mascota.getAclaracionesMedicas(), mascota.getAclaracionesGenerales());
    }
}