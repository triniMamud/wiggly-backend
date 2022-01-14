package app.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected Float age;
    protected String sex;
    protected String size;
    protected String neighbourhood;
    protected Boolean castrated;
    protected String vaccines;
    protected String vaccinesInfo;
    protected String deparasited;
    @Column(name = "illnesses_and_treatments")
    protected String illnessesAndTreatments;
    protected String medicalInfo;
    protected String generalInfo;
}
