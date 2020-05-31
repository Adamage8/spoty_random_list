package com.adam.spotifygeneratedlists.controller;

import com.adam.spotifygeneratedlists.entity.Composition;
import com.adam.spotifygeneratedlists.entity.User;
import com.adam.spotifygeneratedlists.repository.UserRepository;
import com.adam.spotifygeneratedlists.service.CompositionService;
import com.adam.spotifygeneratedlists.service.SpotifyApiService;
import com.adam.spotifygeneratedlists.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/compositions")
@CrossOrigin("http://localhost:4200")
public class CompositionController {

    @Autowired
    private CompositionService compositionService;

    @Autowired
    private UserService userService;

    @Autowired
    private SpotifyApiService spotifyApiService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<Composition>> getAll(@RequestHeader("Authorization") String token) {
        try {
            User user = spotifyApiService.getUserByAuthToken(token);
            return new ResponseEntity<>(user.getCompositions(), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composition> getComposition(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        try {
            User user = spotifyApiService.getUserByAuthToken(token);
            for (Composition listItem : user.getCompositions()) {
                if (listItem.getId().equals(id)) {
                    return new ResponseEntity<>(compositionService.getById(id), HttpStatus.OK);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Composition> postComposition(@RequestBody Composition composition, @RequestHeader("Authorization") String token) {
        try {
            Composition savedComposition = compositionService.create(composition);
            User user = spotifyApiService.getUserByAuthToken(token);
            List<Composition> compositions = user.getCompositions();
            compositions.add(savedComposition);
            user.setCompositions(compositions);
            userRepository.save(user);
            return new ResponseEntity<>(savedComposition, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Composition> patchComposition(@PathVariable Long id, @RequestBody Composition composition, @RequestHeader("Authorization") String token) {
        try {
            User user = spotifyApiService.getUserByAuthToken(token);
            for (Composition listItem : user.getCompositions()) {
                if (listItem.getId().equals(id)) {
                    return new ResponseEntity<>(compositionService.update(id, composition), HttpStatus.NO_CONTENT);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Composition> deleteComposition(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        try {
            User user = spotifyApiService.getUserByAuthToken(token);
            for (Composition listItem : user.getCompositions()) {
                if (listItem.getId().equals(id)) {
                    compositionService.delete(id);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
