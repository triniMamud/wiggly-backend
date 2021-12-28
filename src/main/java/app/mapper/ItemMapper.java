package app.mapper;

import app.model.Mascota;
import app.model.dto.ItemDTO;
import app.model.entity.Perro;

public class ItemMapper {
    public static ItemDTO newItemPetDTO(Mascota pet) {
        return new ItemDTO(pet.getId(),pet.getNombre(),pet.getBarrio(),pet.getSexo());
    }
}