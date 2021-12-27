package app.mapper;

import app.model.Mascota;
import app.model.dto.ItemDTO;

public class ItemMapper {
    public static ItemDTO newItemDTO(Mascota mascota) {
        return new ItemDTO(mascota.getId(),mascota.getNombre(),mascota.getBarrio(),mascota.getSexo());
    }
}
