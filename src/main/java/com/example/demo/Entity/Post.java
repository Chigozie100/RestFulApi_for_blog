package com.example.demo.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String image;
    @CreationTimestamp
    private LocalDateTime localDateTime;

    //onePostManyComments
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    List<PostLike> postlike;
}
