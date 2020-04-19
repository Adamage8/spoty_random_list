package com.adam.spotifygeneratedlists.service;


import com.adam.spotifygeneratedlists.entity.CompositionItem;

import java.util.List;

public interface CompositionItemService {
    public List<CompositionItem> getAll();
    public CompositionItem getById(Long id);
    public CompositionItem create(CompositionItem CompositionItem);
    public CompositionItem update(Long id, CompositionItem CompositionItem);
}
