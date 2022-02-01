package app.service.intefaces;

import app.model.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMyPostulationsService {

    List<ItemDTO> getMyPostulations (String username);

}
