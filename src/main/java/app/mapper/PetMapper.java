package app.mapper;

import app.model.entity.Pet;
import app.model.dto.PetDTO;

public class PetMapper <T extends PetDTO, S extends Pet>{

    /*public T castToPetDTO (Pet pet, Class<T> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                        String.class, String.class, Boolean.class, String.class,
                        String.class, String.class, String.class,
                        String.class, String.class)
                .newInstance(pet.getId(), pet.getName(), pet.getAge(), pet.getSex(),
                        pet.getSex(), pet.getNeighbourhood(), pet.getCastrated(), pet.getVaccines(),
                        pet.getVaccinesInfo(), pet.getDewormed(), pet.getIllnessesAndTreatments(),
                        pet.getMedicalInfo(), pet.getGeneralInfo());
    }

    public Pet castToPet (PetDTO petDto, Class<S> type) throws Exception {
        return type
                .getConstructor(int.class, String.class, Float.class, String.class,
                        String.class, String.class, Boolean.class, String.class,
                        String.class, String.class, String.class,
                        String.class, String.class)
                .newInstance(petDto.getId(), petDto.getName(), petDto.getAge(), petDto.getSex(),
                        petDto.getSex(), petDto.getNeighbourhood(), petDto.getCastrated(), petDto.getVaccines(),
                        petDto.getVaccinesInfo(), petDto.getDewormed(), petDto.getIllnessesAndTreatments(),
                        petDto.getMedicalInfo(), petDto.getGeneralInfo());
    }*/
}
