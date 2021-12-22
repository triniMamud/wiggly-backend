package app.service;

import app.model.dto.PerroDTO;

import java.util.List;

public interface IPerrosService {
    List<PerroDTO> getPerrosList();
    PerroDTO altaPerro(PerroDTO mascota);
}
