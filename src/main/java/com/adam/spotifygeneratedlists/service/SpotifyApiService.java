package com.adam.spotifygeneratedlists.service;

import com.adam.spotifygeneratedlists.entity.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

public interface SpotifyApiService {
    User getUserByAuthToken(String token) throws IOException;
}
