package com.example.demo.Service;

import com.example.demo.DTO.PostLikeDto;
import com.example.demo.Entity.PostLike;

public interface IPostLikeService {
    PostLike likePost(int userId, int postId);


}
