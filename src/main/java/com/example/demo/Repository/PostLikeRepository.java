package com.example.demo.Repository;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.PostLike;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {
    PostLike findPostLikeByUserAndPost(User user, Post post);
}
