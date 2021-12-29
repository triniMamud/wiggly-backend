package app.service.common;

import app.mapper.ItemMapper;
import app.model.Adoptant;
import app.model.Pet;
import app.model.MyPets;
import app.model.dto.ItemDTO;
import app.model.dto.AdoptantDTO;
import app.model.entity.User;
import app.repository.IUsersRepository;
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
    IUsersRepository usuariosRepository;

    protected List<ItemDTO> getMyPets(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPetsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPets.class.cast(myPet).getUser()))
                .forEach(myPet -> itemPetList.add(ItemMapper.newItemPetDTO((Pet) mascotaRepository.findById(MyPets.class.cast(myPet).getPet()).get())));
        return itemPetList;
    }

    public void addToMyPets(int idPet, String username, Class<R> myPetsType) throws Exception {
        myPetsRepository.save(myPetsType.getConstructor(String.class, int.class)
                .newInstance(idPet, username));
    }

    public List<AdoptantDTO> getPostulantesPet(int idPet) {
        List<AdoptantDTO> adoptantDTOS = new ArrayList<>();
        adoptantsRepository.findAll().stream()
                .filter(adoptant -> Adoptant.class.cast(adoptant).getPet() == idPet)
                .forEach(adoptant -> {
                    User user = usuariosRepository.findById(Adoptant.class.cast(adoptant).getUser()).get();
                    adoptantDTOS.add(new AdoptantDTO(user.getNombre(),user.getApellido(), user.getBarrio(), user.getTipoDomicilio()));
                });
        return adoptantDTOS;
    }


}
