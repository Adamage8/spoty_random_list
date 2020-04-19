package com.adam.spotifygeneratedlists.repository;

import com.adam.spotifygeneratedlists.entity.Comment;
import com.adam.spotifygeneratedlists.entity.CopyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRequestRepository extends JpaRepository<CopyRequest, Long> {}
