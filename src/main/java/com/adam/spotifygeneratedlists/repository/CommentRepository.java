package com.adam.spotifygeneratedlists.repository;

import com.adam.spotifygeneratedlists.entity.Comment;
import com.adam.spotifygeneratedlists.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {}
