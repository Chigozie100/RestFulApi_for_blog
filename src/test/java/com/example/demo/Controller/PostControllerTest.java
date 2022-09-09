package com.example.demo.Controller;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.demo.Entity.Post;
import com.example.demo.Service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class PostControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = (ObjectWriter) objectMapper.writer();

    @Mock
    private IPostService iPostService;

    @InjectMocks
    private PostController postController;



    @Test
    void getAllPosts() {
    }

    @Test
    void getPostById() {
    }

    @Test
    void savePost() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}