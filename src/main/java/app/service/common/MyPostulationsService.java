package app.service.common;

import app.exception.types.AlreadyPostulatedException;
import app.exception.types.EntityNotFoundException;
import app.model.dto.HouseTypeDTO;
import app.model.dto.ItemDTO;
import app.model.dto.UserFullDTO;
import app.model.dto.request.AbmMyPostulationReq;
import app.model.dto.response.MyPostulationsDTO;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.model.entity.*;
import app.model.enums.PostulationStatusEnum;
import app.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static app.model.enums.PostulationStatusEnum.SENT;
import static java.time.LocalDateTime.*;

@AllArgsConstructor
@Service
public class MyPostulationsService {

    private final MyPetsService myPetsService;
    private final UsersService usersService;
    private final IMyPostulationsRepository myPostulationsRepository;
    private final IPetRepository petRepository;
    private final IUserRepository userRepository;
    private final IUserAnswersRepository userAnswersRepository;
    private final IHouseTypeRepository houseTypeRepository;
    private final HouseImageService houseImageService;
    private final PetImageService petImageService;
    private final ModelMapper modelMapper;

    public MyPostulationsDTO postulate(String email, AbmMyPostulationReq request) throws AlreadyPostulatedException {
        if (myPostulationsRepository.findByEmailAndPetId(email, request.getPetId()).isPresent())
            throw new AlreadyPostulatedException();

        MyPostulations createdPostulation = myPostulationsRepository.save(
                MyPostulations.builder()
                        .email(email)
                        .petId(request.getPetId())
                        .status(SENT)
                        .sentAt(now())
                        .build());
        return modelMapper.map(createdPostulation, MyPostulationsDTO.class);
    }

    public MyPostulationsDTO updateStatus(String email, Long petId, PostulationStatusEnum newStatus) {
        MyPostulations postulationToUpdate = myPostulationsRepository
                .findByEmailAndPetId(email, petId)
                .orElseThrow(RuntimeException::new);

        postulationToUpdate.setStatus(newStatus);

        switch (newStatus) {
            case RECEIVED -> postulationToUpdate.setReceivedAt(LocalDateTime.now());
            case ACCEPTED, DECLAINED -> postulationToUpdate.setReviewedAt(LocalDateTime.now());
        }

        return modelMapper.map(myPostulationsRepository.save(postulationToUpdate), MyPostulationsDTO.class);
    }

    public MyPostulations get(Long id) {
        return myPostulationsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deletePetFromPostulations(String email, long petId) throws EntityNotFoundException {
        MyPostulations postulation = myPostulationsRepository
                .findByEmailAndPetId(email, petId)
                .orElseThrow(EntityNotFoundException::new);
        myPostulationsRepository.delete(postulation);
    }

    public void delete(Long id) {
        myPostulationsRepository.deleteById(id);
    }

    public List<UserFullDTO> getUsersPetMyPostulations(Long petId) {
        List<MyPostulations> postulationsByPet = myPostulationsRepository.findByPetId(petId).get();
        if (postulationsByPet.size() == 0)
            return new ArrayList<>();
        return postulationsByPet.stream().map(postulation -> {
            UserFullDTO userResponse = new UserFullDTO();
            modelMapper.map(userRepository.findByEmail(postulation.getEmail()).orElse(new User()), userResponse);
            modelMapper.map(userAnswersRepository.findByEmail(postulation.getEmail()).orElse(new UserAnswer()), userResponse);

            HouseTypeDTO houseType = modelMapper.map(houseTypeRepository.findByEmail(postulation.getEmail()).orElse(new HouseType()), HouseTypeDTO.class);
            List<String> houseBytesImages = new ArrayList<>();
            houseImageService.getAllByEmail(postulation.getEmail()).forEach(houseImage -> {
                houseBytesImages.add(houseImage.getImageFilename());
            });
            houseType.setHouseImages(houseBytesImages);
            userResponse.setHouse(houseType);

            return userResponse;
        }).toList();
    }

    public List<PetAdoptionResponseDTO> getMyPostulations(String email) {
        return myPostulationsRepository.findAllByEmail(email).get().stream()
                .map(postulation -> {
                    ItemDTO petItem = modelMapper.map(
                            petRepository.findById(postulation.getPetId()).get(), ItemDTO.class);

                    List<String> petBytesImages = new ArrayList<>();
                    petImageService.getAllByIdPet(postulation.getPetId()).forEach(
                        petImage -> petBytesImages.add(petImage.getImageFilename())
                    );

                    String shelterName = myPetsService
                            .findSheltarNameByPetId(postulation.getPetId())
                            .flatMap(usersService::getShelterNameByEmail)
                            .orElse(null);

                    return new PetAdoptionResponseDTO(
                            postulation.getId(),
                            petItem,
                            postulation.getStatus(),
                            petBytesImages,
                            postulation.getSentAt(),
                            postulation.getReceivedAt(),
                            postulation.getReviewedAt(),
                            shelterName);
                }).toList();
    }
}
