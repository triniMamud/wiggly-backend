package app.model.dto.request;

import app.model.enums.AdoptionTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es válido")
    private String email;

    @NotBlank(message = "El DNI es requerido")
    private String dni;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @NotNull(message = "La edad es requerida")
    @Min(value = 18, message = "Debe ser mayor de 18 años")
    private Integer age;

    @NotNull(message = "El celular es requerido")
    private Long phone;

    @NotBlank(message = "La ubicación es requerida")
    private String location;

    @NotNull(message = "El tipo de adopción es requerido")
    private AdoptionTypeEnum adoptionType;

    // opcional
    private String shelterName;
}
