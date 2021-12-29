package app.service.common;

import app.model.Image;
import app.model.Mascota;
import app.model.dto.MascotaDTO;
import app.model.dto.MascotaDTORequest;
import app.model.dto.MascotaDTOResponse;
import app.model.entity.Todo;
import app.service.intefaces.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public MascotaDTOResponse addMascota(MascotaDTORequest mascota, Class<T> mascotaType, Class<K> imageType) {
        repository.save(mascotaType.cast(mascota));
        mascota.getImages().stream()
                .forEach(img -> {
                    try {
                        imageRepository.save(createImage(mascota,this.todoService.saveTodo(img), imageType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        MascotaDTOResponse mascotaDTOResponse = new MascotaDTOResponse();
        mascotaDTOResponse.setMascota(mascota.getMascota());
        mascota.getImages().stream()
                .forEach(img -> {
                    try {
                        mascotaDTOResponse.getImages().add(img.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return mascotaDTOResponse;
    }

    public List<MascotaDTOResponse> getListMascotas(Class<T> mascotaType) {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        List<MascotaDTOResponse> mascotasResponse = new ArrayList<>();
        repository.findAll()
                .stream()
                .forEach(mascota -> {
                    try {
                        mascotasList.add(cast((Mascota) mascota, mascotaType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        mascotasList.stream()
                .forEach(pet ->  mascotasResponse.add(new MascotaDTOResponse(pet, (List<byte[]>) imageRepository.findAll().stream().filter(img -> ((Image) img).getId_pet() == pet.getId()).collect(Collectors.toList()))));
        return mascotasResponse;
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

    public K createImage(MascotaDTORequest mascotaDTO,Todo todo, Class<K> type) throws Exception {
        return type
                .getConstructor(int.class,int.class)
                .newInstance(mascotaDTO.getMascota().getId(),todo.getId());
    }
}