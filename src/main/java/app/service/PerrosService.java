package app.service;

import app.model.dto.PerroDtoResponse;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerrosService implements IPerrosService{

    @Autowired
    IPerrosRepository perrosRepository;

    @Override
    public List<PerroDtoResponse> getPerrosList() {
        List<PerroDtoResponse> perrosList = new ArrayList<>();
        perrosRepository.findAll()
                .stream()
                .map(perro -> perrosList.add(new PerroDtoResponse(perro)))
                .collect(Collectors.toList());
        return perrosList;
    }

}
