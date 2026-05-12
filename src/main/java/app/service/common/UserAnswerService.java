package app.service.common;

import app.model.dto.HouseTypeDTO;
import app.model.dto.request.CreateUserAnswerRequest;
import app.model.dto.request.UpdateUserAnswerRequest;
import app.model.dto.response.UserAnswerDTO;
import app.model.entity.HouseImage;
import app.model.entity.HouseType;
import app.model.entity.PetImage;
import app.model.entity.UserAnswer;
import app.repository.IUserAnswersRepository;
import app.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class UserAnswerService {

    private final IUserAnswersRepository userAnswersRepository;
    private final HouseImageService houseImageService;
    private final HouseTypeService houseTypeService;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UserAnswerDTO create(String email, CreateUserAnswerRequest request) {
        // guardo las imagenes
        List<HouseImage> houseImagesToSave = request.getHouseTypeRequest().getHouseImages().stream().map(houseImage -> {
            HouseImage houseImageToSave = modelMapper.map(houseImage, HouseImage.class);
            houseImageToSave.setEmail(email);
            return houseImageToSave;
        }).toList();

        List<HouseImage> houseImagesSaved = saveImages(request.getHouseTypeRequest().getHouseImages(), email).stream().toList();
        List<Long> houseImagesSavedIds = houseImagesSaved.stream().map(HouseImage::getId).toList();

        // guardo HouseType
        HouseType houseTypeToSave = modelMapper.map(request.getHouseTypeRequest(), HouseType.class);
        houseTypeToSave.setEmail(email);
        houseTypeToSave.setHouseImageIds(houseImagesSavedIds);

        HouseTypeDTO houseTypeSaved = houseTypeService.save(houseTypeToSave);

        // guardo las answers
        UserAnswer userAnswerToCreate = modelMapper.map(request, UserAnswer.class);
        userAnswerToCreate.setEmail(email);
        userAnswerToCreate.setHouseTypeId(houseTypeSaved.getId());

        UserAnswer userSaved = userAnswersRepository.save(userAnswerToCreate);
        if (nonNull(userSaved))
            userRepository.updateIsFormAnswered(userSaved.getEmail(), true);

        return modelMapper.map(userSaved, UserAnswerDTO.class);
    }

    public List<HouseImage> saveImages(List<String> images, String email) {
        return images.stream().map(imgSrc -> houseImageService.saveImages(imgSrc, imgSrc, email)).toList();
    }

    public UserAnswerDTO update(Long id, UpdateUserAnswerRequest updateRequest) {
        UserAnswer userAnswerToUpdate = userAnswersRepository.findById(id).orElseThrow(RuntimeException::new);
        modelMapper.map(updateRequest, userAnswerToUpdate);

        return modelMapper.map(userAnswersRepository.save(userAnswerToUpdate), UserAnswerDTO.class);
    }

}
