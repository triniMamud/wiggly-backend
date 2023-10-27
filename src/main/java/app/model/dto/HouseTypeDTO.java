package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseTypeDTO {

    private String type;
    private String openSpaces;
    private boolean hasContentionNet;
    private boolean isOwner;
    private boolean allowsPets;
    private List<byte[]> houseImages;
}
