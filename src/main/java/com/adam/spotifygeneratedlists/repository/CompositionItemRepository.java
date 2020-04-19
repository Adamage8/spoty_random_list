package com.adam.spotifygeneratedlists.repository;

import com.adam.spotifygeneratedlists.entity.Comment;
import com.adam.spotifygeneratedlists.entity.CompositionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionItemRepository extends JpaRepository<CompositionItem, Long> {}
