package com.example.demo.Controller;

import com.example.demo.DTO.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Service.IPostService;
import com.example.demo.Utils.Responder;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api (value="blogPost", description="Operations pertaining to online Store")
public class PostController {
    @Autowired
    private IPostService iPostService;

    @Autowired
    private Responder responder;

    //Return all posts
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return iPostService.getAllPost();
    }

    //Returns a post with a given id
    @GetMapping("/posts/{postid}")
    public Post getPostById(@PathVariable("postid") int postId){
        return iPostService.getPostById(postId);
    }

    //Saves a post
    @PostMapping("/posts")
    public ResponseEntity<String> savePost(@RequestBody PostDto post){
        iPostService.save(post);
        return responder.ok();
    }

    //Updates a post with a given id
    @PutMapping("/posts/{postid}")
    public ResponseEntity<String> updatePost(@PathVariable("postid") int postId, @RequestBody PostDto post){
        iPostService.update(postId, post);
        return responder.ok();
    }

    //Deletes a post with a given id
    @DeleteMapping("/posts/{postid}")
    public ResponseEntity<String> deletePost(@PathVariable("postid") int postId){
        iPostService.delete(postId);
        return responder.ok();
    }
}



