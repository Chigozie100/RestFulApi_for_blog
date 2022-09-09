package com.example.demo.Service;

import com.example.demo.DTO.CommentDto;
import com.example.demo.Entity.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllCommentsByPostId(int postid, Pageable page);

    Comment getCommentById(int id);

    void save(CommentDto comment, int id);

    void delete(int id);

    void update(CommentDto comment, int id);
}
