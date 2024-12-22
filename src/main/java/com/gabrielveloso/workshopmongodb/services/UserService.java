package com.gabrielveloso.workshopmongodb.services;

import com.gabrielveloso.workshopmongodb.domain.User;
import com.gabrielveloso.workshopmongodb.dto.UserDTO;
import com.gabrielveloso.workshopmongodb.repositories.UserRepository;
import com.gabrielveloso.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id) {
        if(!(findById(id) == null)) {
            userRepository.deleteById(id);
        }
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
