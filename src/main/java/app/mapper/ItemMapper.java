package app.mapper;

import app.model.Pet;
import app.model.dto.ItemDTO;

public class ItemMapper {
    public static ItemDTO newItemPetDTO(Pet pet) {
        return new ItemDTO(pet.getId(),pet.getNombre(),pet.getBarrio(),pet.getSexo());
    }
}
