package com.example.demo.Service.Implementation;

import com.example.demo.DTO.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.Exception.IllegalArgumentException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.IUserService;
import com.example.demo.Utils.SecurePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveUser(UserDto user) {

        Optional<User> user1 = userRepository.getUserByEmail(user.getEmail());
        User user2 = new User();
        if (user1.isPresent()) {
            throw new IllegalArgumentException("User already exist");
        }
        user2.setEmail(user.getEmail());
        user2.setPassword(SecurePassword.hashPassword(user.getPassword()));
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        userRepository.save(user2);
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.getUserByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public void update(int id, User user) {
        User user1 = userRepository.findById(id).orElse(null);
        if (user1 != null){
            user1.setPassword(user.getPassword());
            userRepository.save(user1);
        }
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
