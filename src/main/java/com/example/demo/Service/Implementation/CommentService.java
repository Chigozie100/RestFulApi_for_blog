package com.example.demo.Service.Implementation;

import com.example.demo.DTO.CommentDto;
import com.example.demo.DTO.PostDto;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Comment> getAllCommentsByPostId(int postid, Pageable page) {
        return commentRepository.findByPostId(postid, page).getContent();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void save(CommentDto comment, int postid) {
        Optional<User> user = userRepository.findById(comment.getUserId());
        Comment comment1 = new Comment();
        Post post = postService.getPostById(postid);
        comment1.setMessage(comment.getMessage());
        comment1.setPost(post);
        comment1.setUser(user.get());
        commentRepository.save(comment1);
    }

    @Override
    public void delete(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void update(CommentDto comment, int id) {
        Optional<User> user = userRepository.findById(comment.getUserId());
        Comment comment1 = getCommentById(id);
        comment1.setMessage(comment.getMessage());
        comment1.setUser(user.get());
        commentRepository.save(comment1);
    }
}
