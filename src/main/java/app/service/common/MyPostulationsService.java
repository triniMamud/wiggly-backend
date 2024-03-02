package app.service.common;

import app.model.dto.HouseTypeDTO;
import app.model.dto.ItemDTO;
import app.model.dto.UserFullDTO;
import app.model.dto.request.CreateMyPostulationsRequest;
import app.model.dto.response.MyPetResponseDTO;
import app.model.dto.response.MyPostulationsDTO;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.model.entity.*;
import app.model.enums.PostulationStatusEnum;
import app.repository.*;
import com.amazonaws.services.mq.model.BadRequestException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static app.model.enums.PostulationStatusEnum.SENT;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@AllArgsConstructor
@Service
public class MyPostulationsService {

    private final IMyPostulationsRepository myPostulationsRepository;
    private final IPetRepository petRepository;
    private final IUserRepository userRepository;
    private final IUserAnswersRepository userAnswersRepository;
    private final IHouseTypeRepository houseTypeRepository;
    private final HouseImageService houseImageService;
    private final PetImageService petImageService;
    private final ModelMapper modelMapper;


    /*public List<ItemDTO> getMyPostulations(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPostulationsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPet.class.cast(myPet).getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(MyPostulation.class.cast(pet).getPet()).get(), ItemDTO.class))
                );
        return itemPetList;
    }*/

    public MyPostulationsDTO postulate(String email, CreateMyPostulationsRequest request) {
        if (myPostulationsRepository.findByEmailAndPetId(email, request.getPetId()).isPresent())
            throw new BadRequestException("El usuario ya se postuló para adoptar la mascota");

        MyPostulations createdPostulation = myPostulationsRepository.save(MyPostulations.builder().email(email).petId(request.getPetId()).status(SENT).build());
        return modelMapper.map(createdPostulation, MyPostulationsDTO.class);
    }

    public MyPostulationsDTO updateStatus(Long postulationId, PostulationStatusEnum newStatus) {
        MyPostulations postulationToUpdate = get(postulationId);
        postulationToUpdate.setStatus(newStatus);

        return modelMapper.map(myPostulationsRepository.save(postulationToUpdate), MyPostulationsDTO.class);
    }

    public MyPostulations get(Long id) {
        return myPostulationsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deletePetFromPostulations(String email, long petId) {
        myPostulationsRepository.deleteByEmailAndIdPet(email, petId);
    }

    public void delete(Long id) {
        myPostulationsRepository.deleteById(id);
    }

    /*public int countMyPetsPostulations(List<Long> myPetIds){
        myPostulationsRepository.findByPetIds(myPetIds).get();
    }*/

    public List<UserFullDTO> getUsersPetMyPostulations(Long petId) {
        List<MyPostulations> postulationsByPet = myPostulationsRepository.findByPetId(petId).get();
        if (postulationsByPet.size() == 0)
            return new ArrayList<>();
        return postulationsByPet.stream().map(postulation -> {
            UserFullDTO userResponse = new UserFullDTO();
            modelMapper.map(userRepository.findByEmail(postulation.getEmail()).orElse(new User()), userResponse);
            modelMapper.map(userAnswersRepository.findByEmail(postulation.getEmail()).orElse(new UserAnswer()), userResponse);

            HouseTypeDTO houseType = modelMapper.map(houseTypeRepository.findByEmail(postulation.getEmail()).orElse(new HouseType()), HouseTypeDTO.class);
            List<byte[]> houseBytesImages = new ArrayList<>();
            houseImageService.getAllByEmail(postulation.getEmail()).forEach(houseImage -> {
                houseBytesImages.add(Base64.getDecoder().decode(houseImage.getImagePath()));
            });
            houseType.setHouseImages(houseBytesImages);
            userResponse.setHouse(houseType);

            return userResponse;
        }).toList();
    }

    public List<PetAdoptionResponseDTO> getMyPostulations(String email) {
        return myPostulationsRepository.findByEmail(email)
                .map(postulation -> {
                    ItemDTO petItem = modelMapper.map(petRepository.findById(postulation.getPetId()).get(), ItemDTO.class);
                    List<String> petBytesImages = new ArrayList<>();
                    petImageService.getAllByIdPet(postulation.getPetId()).forEach(petImage -> {
                        petBytesImages.add(petImage.getImageFilename());
                    });
                    return new PetAdoptionResponseDTO(petItem, postulation.getStatus(), petBytesImages);
                }).stream().toList();
    }
}
