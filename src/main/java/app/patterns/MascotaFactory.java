package app.patterns;

import app.model.MascotasEnum;
import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class MascotaFactory <T>{

    @Autowired
    IPerrosRepository perrosRepository;
    @Autowired
    IGatosRepository gatosRepository;


    public Class<? extends JpaRepository> getRepository(MascotasEnum mascotasEnum, Class<T> type) {
        switch (mascotasEnum.name()){
            case "PERRO": return perrosRepository.getClass();
            case "GATO": return gatosRepository.getClass();
        }
        return null;
    }

    public Object getClass(MascotasEnum mascotasEnum, Class<T> type) {
        switch (mascotasEnum.name()){
            case "PERRO": return perrosRepository;
            case "GATO": return gatosRepository.getClass();
        }
        return null;
    }
}