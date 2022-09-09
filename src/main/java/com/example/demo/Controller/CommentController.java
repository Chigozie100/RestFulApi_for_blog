package com.example.demo.Controller;

import com.example.demo.DTO.CommentDto;
import com.example.demo.Entity.Comment;
import com.example.demo.Service.ICommentService;
import com.example.demo.Utils.Responder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private Responder responder;

    @GetMapping("/posts/{postid}/comments")
    public List<Comment> getAllComments(@PathVariable("postid") int postid, Pageable page){
        return iCommentService.getAllCommentsByPostId(postid, page);
    }

    @PostMapping("/posts/{postid}/comments")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentDto comment, @PathVariable("postid") int postid){
        iCommentService.save(comment, postid);
        ResponseEntity responseEntity = responder.ok();
        return responseEntity;
    }

    @PutMapping("/posts/{postid}/comments{commentid}")
    public ResponseEntity<String> updateComment(@RequestBody CommentDto comment, @PathVariable("postid") int postid){
        iCommentService.update(comment, postid);
        return responder.ok();
    }

    @DeleteMapping("/posts/{postid}/comments/{commentid}")
    public ResponseEntity<String> deleteComment(@PathVariable("postid") int postid){
        iCommentService.delete(postid);
        return responder.ok();
    }
}




