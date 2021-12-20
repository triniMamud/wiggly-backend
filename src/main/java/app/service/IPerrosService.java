package app.service;

import app.model.dto.PerroDtoResponse;

import java.util.List;

public interface IPerrosService {
    List<PerroDtoResponse> getPerrosList();
}
