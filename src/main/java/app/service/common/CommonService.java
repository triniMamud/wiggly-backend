package app.service.common;

import app.model.PetImage;
import app.model.Pet;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.entity.Image;
import app.service.intefaces.IImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

public class CommonService<S extends JpaRepository, T extends PetDTO, Q extends Pet, R extends JpaRepository, K extends PetImage> {

    private S repository;
    private R imageRepository;
    private IImageService todoService;

    @Autowired
    public CommonService(S repository, IImageService todoService, R imageRepository) {
        this.repository = repository;
        this.imageRepository = imageRepository;
        this.todoService = todoService;
    }

    public PetDTOResponse addMascota(PetDTORequest mascota, Class<Q> mascotaType, Class<K> imageType) throws Exception {
        repository.save(castToMascota(mascota.getMascota(), mascotaType));
        mascota.getImages().stream()
                .forEach(img -> {
                    try {
                        imageRepository.save(createImage(mascota,this.todoService.saveTodo(img), imageType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        PetDTOResponse petDTOResponse = new PetDTOResponse();
        petDTOResponse.setMascota(mascota.getMascota());
        mascota.getImages().stream()
                .forEach(img -> {
                    try {
                        petDTOResponse.getImages().add(img.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return petDTOResponse;
    }

    public List<PetDTOResponse> getListMascotas(Class<T> mascotaType) {
        List<PetDTO> mascotasList = new ArrayList<>();
        List<PetDTOResponse> mascotasResponse = new ArrayList<>();
        repository.findAll()
                .stream()
                .forEach(mascota -> {
                    try {
                        mascotasList.add(castToDTO((Pet) mascota, mascotaType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        mascotasList.stream()
                .forEach(pet ->  mascotasResponse.add(new PetDTOResponse(pet, (List<byte[]>) imageRepository.findAll().stream().filter(img -> ((PetImage) img).getId_pet() == pet.getId()).collect(Collectors.toList()))));
        return mascotasResponse;
    }

    public PetDTO editMascota(int idMascota, PetDTO mascota, Class<T> mascotaType) throws Exception {
        Pet petDB = (Pet) repository.findById(idMascota).get();
        Set<String> nullProperties = new HashSet<>();

        Arrays.stream(PetDTO.class.getFields()).forEach(field -> {
            try {
                if (field.get(mascota) == null) {
                    nullProperties.add(field.getName());
                }
            } catch (IllegalAccessException e) { e.printStackTrace(); }
        });

        BeanUtils.copyProperties(petDB, mascota, new String[nullProperties.size()]);
        return castToDTO((Pet)repository.save(petDB), mascotaType);
    }

    public T castToDTO (Pet pet, Class<T> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                String.class, String.class, Boolean.class, String.class,
                String.class, String.class, String.class,
                String.class, String.class)
                .newInstance(pet.getId(), pet.getNombre(), pet.getEdadAprox(), pet.getSexo(),
                        pet.getTamanio(), pet.getBarrio(), pet.getCastrado(), pet.getVacunas(),
                        pet.getAclaracionesVacunas(), pet.getDesparacitado(), pet.getEnfermedadesYTratamientos(),
                        pet.getAclaracionesMedicas(), pet.getAclaracionesGenerales());
    }

    public K createImage(PetDTORequest mascotaDTO, Image image, Class<K> type) throws Exception {
        return type
                .getConstructor(int.class,int.class)
                .newInstance(mascotaDTO.getMascota().getId(), image.getId());
    }
    public Pet castToMascota (PetDTO petDto, Class<Q> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                        String.class, String.class, Boolean.class, String.class,
                        String.class, String.class, String.class,
                        String.class, String.class)
                .newInstance(petDto.getId(), petDto.getNombre(), petDto.getEdadAprox(), petDto.getSexo(),
                        petDto.getTamanio(), petDto.getBarrio(), petDto.getCastrado(), petDto.getVacunas(),
                        petDto.getAclaracionesVacunas(), petDto.getDesparacitado(), petDto.getEnfermedadesYTratamientos(),
                        petDto.getAclaracionesMedicas(), petDto.getAclaracionesGenerales());
    }
}