package com.adam.spotifygeneratedlists.controller;

import com.adam.spotifygeneratedlists.entity.Composition;
import com.adam.spotifygeneratedlists.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compositions")
public class CompositionController {

    @Autowired
    private CompositionService compositionService;

    @GetMapping("/")
    public ResponseEntity<List<Composition>> getAll() {
        return new ResponseEntity<>(compositionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composition> getComposition(@PathVariable Long id) {
        return new ResponseEntity<>(compositionService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Composition> postComposition(@RequestBody Composition composition) {
        return new ResponseEntity<>(compositionService.create(composition), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Composition> patchComposition(@PathVariable Long id, @RequestBody Composition composition) {
        return new ResponseEntity<>(compositionService.update(id, composition), HttpStatus.OK);
    }

}
