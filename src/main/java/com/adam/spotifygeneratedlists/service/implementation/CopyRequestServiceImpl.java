package com.adam.spotifygeneratedlists.service.implementation;


import com.adam.spotifygeneratedlists.entity.CopyRequest;
import com.adam.spotifygeneratedlists.repository.CopyRequestRepository;
import com.adam.spotifygeneratedlists.service.CopyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CopyRequestServiceImpl implements CopyRequestService {

    @Autowired
    private CopyRequestRepository copyRequestRepository;

    @Override
    public List<CopyRequest> getAll() {
        return copyRequestRepository.findAll();
    }

    @Override
    public CopyRequest getById(Long id) {
        return copyRequestRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public CopyRequest create(CopyRequest copyRequest) {
        return copyRequestRepository.save(copyRequest);
    }

    @Override
    public CopyRequest update(Long id, CopyRequest copyRequest) {
        CopyRequest modifiedCopyRequest = copyRequestRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return copyRequestRepository.save(modifiedCopyRequest);
    }
}
