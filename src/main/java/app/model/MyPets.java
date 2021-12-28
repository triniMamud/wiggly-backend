package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class MyPets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private int pet;

    public MyPets(String username, int idPet) {
        this.user = username;
        this.pet = idPet;
    }
}
