package app.service.common;

import app.model.dto.HouseTypeDTO;
import app.model.dto.request.CreateHouseTypeRequest;
import app.model.dto.request.CreateUserAnswerRequest;
import app.model.dto.request.UpdateUserAnswerRequest;
import app.model.dto.response.UserAnswerDTO;
import app.model.entity.HouseType;
import app.model.entity.UserAnswer;
import app.repository.IHouseTypeRepository;
import app.repository.IUserAnswersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HouseTypeService {

    private final IHouseTypeRepository houseTypeRepository;

    private final ModelMapper modelMapper;

    public HouseTypeDTO save(HouseType houseTypeToSave) {
        return modelMapper.map(houseTypeRepository.save(houseTypeToSave), HouseTypeDTO.class);
    }

}
