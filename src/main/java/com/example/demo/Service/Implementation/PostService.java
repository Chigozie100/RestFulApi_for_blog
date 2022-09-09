package com.example.demo.Service.Implementation;

import com.example.demo.DTO.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Post> getAllPost() {
        return new ArrayList<Post>(postRepository.findAll());
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void save(PostDto post) {
        Optional<User> user = userRepository.findById(post.getUserId());
        Post post1 = new Post();
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setUser(user.get());
        postRepository.save(post1);
    }

    @Override
    public void delete(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public void update(int id, PostDto post) {
        Optional<User> user = userRepository.findById(post.getUserId());
        Post post1 = postRepository.findById(id).orElse(null);
        if (post1 != null){
            post1.setTitle(post.getTitle());
            post1.setContent(post.getContent());
            post1.setUser(user.get());
            postRepository.save(post1);
        }

    }
}
