package com.adam.spotifygeneratedlists.service;


import com.adam.spotifygeneratedlists.entity.CopyRequest;

import java.util.List;

public interface CopyRequestService {
    public List<CopyRequest> getAll();
    public CopyRequest getById(Long id);
    public CopyRequest create(CopyRequest CopyRequest);
    public CopyRequest update(Long id, CopyRequest CopyRequest);
}
