package com.example.demo.Controller;

import com.example.demo.DTO.PostDto;
import com.example.demo.DTO.UserDto;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Service.IUserService;
import com.example.demo.Utils.Responder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    IUserService iUserService;

    @Autowired
    private Responder responder;
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDto user){
        iUserService.saveUser(user);
        return responder.ok();
    }

    @GetMapping("/users")
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return iUserService.getUserByEmailAndPassword(email, password);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable("userId") int userId, @RequestBody User user){
        iUserService.update(userId, user);
        return responder.ok();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId){
        iUserService.delete(userId);
        return responder.ok();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String email, String password, HttpSession session){
       Optional<User> user = iUserService.getUserByEmailAndPassword(email, password);
       if (user.isEmpty()){
           return responder.notFound();
       }
       session.setAttribute("user", user);
       return responder.ok();
    }
}

