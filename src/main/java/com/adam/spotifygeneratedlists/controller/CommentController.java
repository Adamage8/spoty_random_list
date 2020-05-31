package com.adam.spotifygeneratedlists.controller;

import com.adam.spotifygeneratedlists.entity.Comment;
import com.adam.spotifygeneratedlists.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.create(comment), HttpStatus.OK);
    }

}
