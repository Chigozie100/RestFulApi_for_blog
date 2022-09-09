package com.example.demo.Service;

import com.example.demo.DTO.PostDto;
import com.example.demo.Entity.Post;

import java.util.List;

public interface IPostService {

    List<Post> getAllPost();

    Post getPostById(int id);

    void save(PostDto post);

    void delete(int id);

    void update(int id, PostDto post);
}
