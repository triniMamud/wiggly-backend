package app.service.common;

import app.model.entity.HouseImage;
import app.model.entity.PetImage;
import app.repository.IHouseImageRepository;
import app.repository.IPetImageRepository;
import app.repository.IPetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseImageService {

    private final IHouseImageRepository houseImageRepository;
    private final IPetRepository petRepository;
    private final ImageService imageService;

    public List<HouseImage> getAllByEmail(String email) {
        return houseImageRepository.findByEmail(email);
    }
}
