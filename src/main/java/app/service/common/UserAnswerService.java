package app.service.common;

import app.model.dto.HouseTypeDTO;
import app.model.dto.request.CreateUserAnswerRequest;
import app.model.dto.request.UpdateUserAnswerRequest;
import app.model.dto.response.UserAnswerDTO;
import app.model.entity.HouseImage;
import app.model.entity.HouseType;
import app.model.entity.UserAnswer;
import app.repository.IUserAnswersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAnswerService {

    private final IUserAnswersRepository userAnswersRepository;

    private final HouseImageService houseImageService;

    private final HouseTypeService houseTypeService;

    private final ModelMapper modelMapper;

    public UserAnswerDTO create(String email, CreateUserAnswerRequest request) {
        // guardo las imagenes
        List<HouseImage> houseImagesToSave = request.getHouseTypeRequest().getHouseImagesRequest().stream().map(houseImage -> {
            HouseImage houseImageToSave = modelMapper.map(houseImage, HouseImage.class);
            houseImageToSave.setEmail(email);
            return houseImageToSave;
        }).toList();

        List<HouseImage> houseImagesSaved = houseImageService.saveImages(houseImagesToSave.stream().map(HouseImage::getImagePath).toList(), email);
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

        return modelMapper.map(userAnswersRepository.save(userAnswerToCreate), UserAnswerDTO.class);
    }

    public UserAnswerDTO update(Long id, UpdateUserAnswerRequest updateRequest) {
        UserAnswer userAnswerToUpdate = userAnswersRepository.findById(id).orElseThrow(RuntimeException::new);
        modelMapper.map(updateRequest, userAnswerToUpdate);

        return modelMapper.map(userAnswersRepository.save(userAnswerToUpdate), UserAnswerDTO.class);
    }

}
