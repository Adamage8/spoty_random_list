package com.adam.spotifygeneratedlists.service.implementation;

import com.adam.spotifygeneratedlists.entity.User;
import com.adam.spotifygeneratedlists.repository.CompositionRepository;
import com.adam.spotifygeneratedlists.service.SpotifyApiService;
import com.adam.spotifygeneratedlists.service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Service
public class SpotifyApiServiceImpl implements SpotifyApiService {

    @Autowired
    private UserService userService;

    @Override
    public User getUserByAuthToken(String token) throws IOException {
        User user = null;
        URL url = new URL("https://api.spotify.com/v1/me");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty ("Authorization", token);

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        for (String line; (line = reader.readLine()) != null; ) {
            builder.append(line);
        }
        JsonObject jsonObject = new JsonParser().parse(builder.toString()).getAsJsonObject();
        String spotifyId = jsonObject.get("id").getAsString();
        try{
            user = userService.getByClientId(spotifyId);
        }catch (EntityNotFoundException e){
            User newUser = new User();
            newUser.setClientId(spotifyId);
            newUser.setName(spotifyId);
            userService.create(newUser);
            user = newUser;
        }
        return user;
    }
}
