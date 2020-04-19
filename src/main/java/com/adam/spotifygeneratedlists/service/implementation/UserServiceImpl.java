package com.adam.spotifygeneratedlists.service.implementation;


import com.adam.spotifygeneratedlists.entity.User;
import com.adam.spotifygeneratedlists.repository.UserRepository;
import com.adam.spotifygeneratedlists.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User modifiedUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userRepository.save(modifiedUser);
    }
}
