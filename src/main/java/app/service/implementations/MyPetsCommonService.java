package app.service.implementations;

import app.mapper.ItemMapper;
import app.model.Adoptant;
import app.model.Mascota;
import app.model.MyPets;
import app.model.dto.ItemDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PostulantesDTO;
import app.model.entity.MyDogs;
import app.model.entity.Usuario;
import app.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class MyPetsCommonService <S extends JpaRepository, T extends JpaRepository, V extends JpaRepository, R extends MyPets> {

    @Autowired
    S myPetsRepository;
    @Autowired
    T mascotaRepository;
    @Autowired
    V adoptantsRepository;
    @Autowired
    IUsuariosRepository usuariosRepository;

    List<ItemDTO> getMyPets(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPetsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPets.class.cast(myPet).getUser()))
                .forEach(myPet -> itemPetList.add(ItemMapper.newItemPetDTO((Mascota) mascotaRepository.findById(MyPets.class.cast(myPet).getPet()).get())));
        return itemPetList;
    }

    public void addToMyPets(int idPet, String username, Class<R> myPetsType) throws Exception {
        myPetsRepository.save(myPetsType.getConstructor(String.class, int.class)
                .newInstance(idPet, username));
    }

    public List<PostulantesDTO> getPostulantesPet(int idPet) {
        List<PostulantesDTO> postulantesDTOS = new ArrayList<>();
        adoptantsRepository.findAll().stream()
                .filter(adoptant -> Adoptant.class.cast(adoptant).getPet() == idPet)
                .forEach(adoptant -> {
                    Usuario user = usuariosRepository.findById(Adoptant.class.cast(adoptant).getUser()).get();
                    postulantesDTOS.add(new PostulantesDTO(user.getNombre(),user.getApellido(), user.getBarrio(), user.getTipoDomicilio()));
                });
        return postulantesDTOS;
    }


}
