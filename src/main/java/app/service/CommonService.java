package app.service;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import org.hibernate.criterion.Example;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonService<S extends JpaRepository, T extends  MascotaDTO, R extends Mascota> {

    @Autowired
    S repository;

    public void addMascota(MascotaDTO mascota, Class<R> mascotaType) throws Exception {
        repository.save(castToMascota(mascota, mascotaType));
    }

    public List<MascotaDTO> getListMascotas(Class<T> mascotaType) {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        repository.findAll()
                .stream()
                .forEach(mascota -> {
                    try {
                        mascotasList.add(castToDTO((Mascota) mascota, mascotaType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return mascotasList;
    }

    public MascotaDTO editMascota( int idMascota, MascotaDTO mascota, Class<T> mascotaType) throws Exception {
        Mascota mascotaDB = (Mascota) repository.findById(idMascota).get();
        Set<String> nullProperties = new HashSet<>();

        Arrays.stream(MascotaDTO.class.getFields()).forEach(field -> {
            try {
                if (field.get(mascota) == null) {
                    nullProperties.add(field.getName());
                }
            } catch (IllegalAccessException e) { e.printStackTrace(); }
        });

        BeanUtils.copyProperties(mascotaDB, mascota, new String[nullProperties.size()]);
        return castToDTO((Mascota)repository.save(mascotaDB), mascotaType);
    }

    public T castToDTO (Mascota mascota, Class<T> type) throws Exception {
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
    public Mascota castToMascota (MascotaDTO mascotaDto, Class<R> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                        String.class, String.class, Boolean.class, String.class,
                        String.class, String.class, String.class,
                        String.class, String.class)
                .newInstance(mascotaDto.getId(), mascotaDto.getNombre(), mascotaDto.getEdadAprox(), mascotaDto.getSexo(),
                        mascotaDto.getTamanio(), mascotaDto.getBarrio(), mascotaDto.getCastrado(), mascotaDto.getVacunas(),
                        mascotaDto.getAclaracionesVacunas(), mascotaDto.getDesparacitado(), mascotaDto.getEnfermedadesYTratamientos(),
                        mascotaDto.getAclaracionesMedicas(), mascotaDto.getAclaracionesGenerales());
    }
}