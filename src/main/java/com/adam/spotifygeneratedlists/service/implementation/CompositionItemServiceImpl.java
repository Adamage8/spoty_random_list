package com.adam.spotifygeneratedlists.service.implementation;


import com.adam.spotifygeneratedlists.entity.CompositionItem;
import com.adam.spotifygeneratedlists.repository.CompositionItemRepository;
import com.adam.spotifygeneratedlists.service.CompositionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompositionItemServiceImpl implements CompositionItemService {

    @Autowired
    private CompositionItemRepository compositionItemRepository;

    @Override
    public List<CompositionItem> getAll() {
        return compositionItemRepository.findAll();
    }

    @Override
    public CompositionItem getById(Long id) {
        return compositionItemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public CompositionItem create(CompositionItem compositionItem) {
        return compositionItemRepository.save(compositionItem);
    }

    @Override
    public CompositionItem update(Long id, CompositionItem compositionItem) {
        CompositionItem modifiedCompositionItem = compositionItemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return compositionItemRepository.save(modifiedCompositionItem);
    }
}
