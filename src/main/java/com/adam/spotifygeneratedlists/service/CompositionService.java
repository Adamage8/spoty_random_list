package com.adam.spotifygeneratedlists.service;


import com.adam.spotifygeneratedlists.entity.Composition;

import java.util.List;

public interface CompositionService {
    public List<Composition> getAll();
    public Composition getById(Long id);
    public Composition create(Composition Composition);
    public Composition update(Long id, Composition Composition);
}
