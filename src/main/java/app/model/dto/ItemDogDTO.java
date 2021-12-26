package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDogDTO {
    private int id;
    private String nombre;
    private String barrio;
    private String sexo;
}
