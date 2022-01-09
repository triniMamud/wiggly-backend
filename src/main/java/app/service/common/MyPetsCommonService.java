package app.service.common;

import app.model.Adoptant;
import app.model.MyPets;
import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;
import app.model.entity.User;
import app.repository.IUsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class MyPetsCommonService <S extends JpaRepository, T extends JpaRepository, V extends JpaRepository, R extends MyPets> {

    private final S myPetsRepository;
    private final T petRepository;
    private final V adoptantsRepository;
    private final IUsersRepository usersRepository;

    private ModelMapper mapper = new ModelMapper();


    @Autowired
    public MyPetsCommonService (S myPetsRepository, T petRepository, V adoptantsRepository, IUsersRepository usersRepository) {
        this.myPetsRepository = myPetsRepository;
        this.petRepository = petRepository;
        this.adoptantsRepository = adoptantsRepository;
        this.usersRepository = usersRepository;
    }

    protected List<ItemDTO> getMyPets(String username) {
        List<ItemDTO> itemPetList = new ArrayList<>();

        myPetsRepository.findAll().stream()
                .filter(myPet -> username.equalsIgnoreCase(MyPets.class.cast(myPet).getUsername()))
                .forEach(pet -> itemPetList.add(mapper.map(petRepository.findById(MyPets.class.cast(pet).getPet()).get(), ItemDTO.class))
                );
        return itemPetList;
    }

    public boolean addToMyPets(int idPet, String username, Class<R> myPetsType) throws Exception {
        return (myPetsRepository.save(myPetsType.getConstructor(String.class, int.class).newInstance(username, idPet)) != null);
    }

    public List<AdoptantDTO> getAdoptantsPet(int idPet) {
        List<AdoptantDTO> adoptantDTOS = new ArrayList<>();
        adoptantsRepository.findAll().stream()
                .filter(adoptant -> Adoptant.class.cast(adoptant).getPet() == idPet)
                .forEach(adoptant -> {
                    User user = usersRepository.findById(Adoptant.class.cast(adoptant).getUser()).get();
                    adoptantDTOS.add(new AdoptantDTO(user.getName(), user.getLastName(), user.getNeighbourhood(), user.getHouseType()));
                });
        return adoptantDTOS;
    }
}
