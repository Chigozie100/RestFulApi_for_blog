package com.example.demo.Controller;

import com.example.demo.DTO.PostDto;
import com.example.demo.Service.IPostLikeService;
import com.example.demo.Service.Implementation.PostLikeService;
import com.example.demo.Utils.Responder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostLikeController {
    @Autowired
  private IPostLikeService service;

    @Autowired
    private Responder responder;


    @PostMapping("/like/{userId}/{postId}")
    public ResponseEntity<String> savelike(@PathVariable("userId") int userId, @PathVariable("postId") int postId){
        service.likePost(userId, postId);
        return responder.ok();
    }
}
