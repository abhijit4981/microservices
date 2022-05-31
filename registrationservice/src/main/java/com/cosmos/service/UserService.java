package com.cosmos.service;

import com.cosmos.entity.CustomResponse;
import com.cosmos.entity.User;
import com.cosmos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getMobileNumber()).orElse(null);
        return repository.save(existingUser);
    }


    public ResponseEntity validateUser(User user) {
        Long mobileNumber = user.getMobileNumber();
        boolean status=false;
        Optional<User> optionalUser = repository.findById(mobileNumber);
        if(optionalUser.isPresent()){
            status = validatePassword(optionalUser.get().getPassword(),user.getPassword());
        }
        if(status=true){
            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.OK);
            customResponse.setMessage("User validated successfully");
            new ResponseEntity<SUCC>()
        }
    }

    private Boolean validatePassword(String password, String password1) {
    }
}
