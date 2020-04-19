package com.adam.spotifygeneratedlists.service;


import com.adam.spotifygeneratedlists.entity.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getAll();
    public Comment getById(Long id);
    public Comment create(Comment Comment);
    public Comment update(Long id, Comment Comment);
}
