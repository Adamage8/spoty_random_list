package com.adam.spotifygeneratedlists.service;


import com.adam.spotifygeneratedlists.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(Long id);
    public User create(User user);
    public User update(Long id, User user);
}
