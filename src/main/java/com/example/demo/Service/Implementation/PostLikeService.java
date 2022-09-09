package com.example.demo.Service.Implementation;

import com.example.demo.DTO.PostLikeDto;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.PostLike;
import com.example.demo.Entity.User;
import com.example.demo.Exception.IllegalArgumentException;
import com.example.demo.Repository.PostLikeRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.IPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostLikeService implements IPostLikeService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostLikeRepository postLikeRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public PostLike likePost(int userId, int postId) {
        User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("Post not found"));

        PostLike postLike = postLikeRepository.findPostLikeByUserAndPost(user,post);

        PostLike postLike1 = new PostLike();
        if (postLike == null){
            postLike1.setLiked(true);
            postLike1.setUser(user);
            postLike1.setPost(post);
            return postLikeRepository.save(postLike1);
        } else if (postLike != null && postLike.isLiked() == true) {
            postLike.setLiked(false);
            postLike.setUser(user);
            postLike.setPost(post);
          return postLikeRepository.save(postLike1);
        }

        postLike.setLiked(true);
        postLike.setUser(user);
        postLike.setPost(post);

       return postLikeRepository.save(postLike);
    }

}
