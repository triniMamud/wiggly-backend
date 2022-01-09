package app.service.common;

import app.model.Pet;
import app.model.PetImage;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.model.entity.Image;
import app.service.intefaces.IImageService;
import com.sun.xml.bind.v2.TODO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static app.config.Utils.safeIsNotEmpty;

public class CommonService<S extends JpaRepository, T extends PetDTO, Q extends Pet, R extends JpaRepository, K extends PetImage> {

    private final S petRepository;
    private final R imageRepository;
    private final IImageService imageService;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public CommonService(S petRepository, IImageService imageService, R imageRepository) {
        this.petRepository = petRepository;
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }

    public PetDTOResponse addNewPet(PetDTORequest petRequest, Class<Q> petType, Class<K> imageType) {

        PetDTOResponse petResponse = new PetDTOResponse();
        petResponse.setPet(mapper.map(petRepository.save(mapper.map(petRequest.getPet(), petType)), PetDTO.class));
        saveImages(petRequest, petResponse, imageType);

        return petResponse;
    }

    public List<PetDTOResponse> getListPets(Class<T> petType) {
        List<PetDTO> petsDTOList = new ArrayList<>();
        List<PetDTOResponse> petResponseList = new ArrayList<>();
        petRepository.findAll().forEach(pet -> {
                    try {
                        petsDTOList.add(mapper.map(pet, petType));

                        List<byte[]> petBytesImages = (List<byte[]>) imageRepository.findAll()
                                .stream()
                                .filter(img -> ((PetImage) img).getIdPet() == ((Pet)pet).getId())
                                .collect(Collectors.toList());
                        petResponseList.add(new PetDTOResponse(mapper.map(pet, petType), petBytesImages));
                    } catch (Exception e) { e.printStackTrace(); }
                });

        return petResponseList;
    }

    public void editPet(int idPet, PetDTORequest petRequest, Class<T> petType, Class<K> imageType) {
        Pet petDB = (Pet) petRepository.findById(idPet).get();
        Set<String> nullProperties = new HashSet<>();
        PetDTOResponse petResponse = new PetDTOResponse();
        petResponse.setPet(petRequest.getPet());

        if (safeIsNotEmpty(petRequest.getImages())){
            saveImages(petRequest, petResponse, imageType);
        }

        Arrays.stream(PetDTO.class.getFields()).forEach(field -> {
            try {
                if (field.get(petRequest) == null) {
                    nullProperties.add(field.getName());
                }
            } catch (IllegalAccessException e) { e.printStackTrace(); }
        });

        BeanUtils.copyProperties(petDB, petRequest, new String[nullProperties.size()]);
        mapper.map(petRepository.save(petDB), petType);
    }

    public void saveImages(PetDTORequest petRequest, PetDTOResponse petResponse, Class<K> imageType) {
        petRequest.getImages().forEach(img -> {
            try {
                imageRepository.save(createImage(petRequest,this.imageService.saveImage(img), imageType));
                petResponse.getImages().add(img.getBytes());
            } catch (Exception e) { e.printStackTrace(); }
        });
    }

    public K createImage(PetDTORequest petDTORequest, Image image, Class<K> type) throws Exception {
        return type
                .getConstructor(int.class,int.class)
                .newInstance(petDTORequest.getPet().getId(), image.getId());
    }
}