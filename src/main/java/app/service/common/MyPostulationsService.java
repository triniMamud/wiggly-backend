package app.service.common;

import app.model.dto.ItemDTO;
import app.model.dto.UserFullDTO;
import app.model.dto.response.MyPetResponseDTO;
import app.model.entity.HouseType;
import app.model.entity.MyPostulations;
import app.model.entity.User;
import app.model.entity.UserAnswer;
import app.model.enums.PostulationStatusEnum;
import app.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private final ImageService imageService;
    private final ModelMapper modelMapper;


    /*public List<ItemDTO> getMyPostulations(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPostulationsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPet.class.cast(myPet).getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(MyPostulation.class.cast(pet).getPet()).get(), ItemDTO.class))
                );
        return itemPetList;
    }*/

    public boolean postulate(String email, long idPet) {
        MyPostulations myPostulations = myPostulationsRepository.findByEmail(email).orElse(MyPostulations.builder().email(email).build());
        myPostulations.setPetId(idPet);
        myPostulations.setStatus(PostulationStatusEnum.SENT);
        return isNotEmpty(myPostulationsRepository.save(myPostulations));
    }

    public void deletePetFromPostulations(String email, long petId) {
        myPostulationsRepository.deleteByEmailAndIdPet(email, petId);
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
            modelMapper.map(houseTypeRepository.findByEmail(postulation.getEmail()).orElse(new HouseType()), userResponse);

            List<byte[]> houseBytesImages = new ArrayList<>();
            houseImageService.getAllByEmail(postulation.getEmail()).forEach(houseImage -> {
                houseBytesImages.add(imageService.downloadImage(houseImage.getImagePath(), houseImage.getImageFilename()));
            });
            userResponse.setHouseImages(houseBytesImages);
            return userResponse;
        }).toList();
    }
}
