package com.example.demo.Service;

import com.example.demo.DTO.UserDto;
import com.example.demo.Entity.User;

import java.util.Optional;

public interface IUserService {
    void saveUser(UserDto user);

    Optional<User> getUserByEmailAndPassword(String email, String password);

    void update(int id, User user);

    void delete(int id);
}
