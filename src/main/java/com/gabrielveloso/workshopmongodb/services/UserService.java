package com.gabrielveloso.workshopmongodb.services;

import com.gabrielveloso.workshopmongodb.domain.User;
import com.gabrielveloso.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
