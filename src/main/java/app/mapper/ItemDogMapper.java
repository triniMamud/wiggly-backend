package app.mapper;

import app.model.dto.ItemDogDTO;
import app.model.entity.Perro;

public class ItemDogMapper {
    public static ItemDogDTO newItemDogDTO(Perro perro) {
        return new ItemDogDTO(perro.getId(),perro.getNombre(),perro.getBarrio(),perro.getSexo());
    }
}
