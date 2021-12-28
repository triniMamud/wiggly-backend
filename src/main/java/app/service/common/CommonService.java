package app.service.common;

import app.model.Image;
import app.model.Mascota;
import app.model.dto.MascotaDTO;
import app.model.entity.Todo;
import app.service.intefaces.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class CommonService<S extends JpaRepository, T extends MascotaDTO, R extends JpaRepository, K extends Image> {

    private S repository;
    private R imageRepository;
    private ITodoService todoService;

    @Autowired
    public CommonService(S repository, ITodoService todoService, R imageRepository) {
        this.repository = repository;
        this.imageRepository = imageRepository;
        this.todoService = todoService;
    }

    public void addMascota(MascotaDTO mascota, Class<T> mascotaType, Class<K> imageType) {
        repository.save(mascotaType.cast(mascota));
        mascota.getImages().stream()
                .forEach(img -> {
                    try {
                        imageRepository.save(createImage(mascota,this.todoService.saveTodo(img), imageType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
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

    public K createImage(MascotaDTO mascotaDTO,Todo todo, Class<K> type) throws Exception {
        return type
                .getConstructor(int.class,int.class)
                .newInstance(mascotaDTO.getId(),todo.getId());
    }
}