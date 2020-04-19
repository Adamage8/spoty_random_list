package com.adam.spotifygeneratedlists.service.implementation;


import com.adam.spotifygeneratedlists.entity.Comment;
import com.adam.spotifygeneratedlists.repository.CommentRepository;
import com.adam.spotifygeneratedlists.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        Comment modifiedComment = commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return commentRepository.save(modifiedComment);
    }
}
