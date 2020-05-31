package com.adam.spotifygeneratedlists.service.implementation;


import com.adam.spotifygeneratedlists.entity.Composition;
import com.adam.spotifygeneratedlists.repository.CompositionRepository;
import com.adam.spotifygeneratedlists.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompositionServiceImpl implements CompositionService {

    @Autowired
    private CompositionRepository compositionRepository;

    @Override
    public List<Composition> getAll() {
        return compositionRepository.findAll();
    }

    @Override
    public Composition getById(Long id) {
        return compositionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Composition create(Composition composition) {
        return compositionRepository.save(composition);
    }

    @Override
    public Composition update(Long id, Composition composition) {
        Composition modifiedComposition = compositionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modifiedComposition.setName(composition.getName());
        modifiedComposition.setNumberOfItems(composition.getNumberOfItems());
        modifiedComposition.setCompositionItems(composition.getCompositionItems());
        modifiedComposition.setComments(composition.getComments());
        return compositionRepository.save(modifiedComposition);
    }

    @Override
    public void delete(Long id) {
        Composition compositionToDelete = compositionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        compositionRepository.delete(compositionToDelete);
    }
}
