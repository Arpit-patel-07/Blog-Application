package com.example.BlogApplication.Dtos;

import com.example.BlogApplication.Entities.Category;
import com.example.BlogApplication.Entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PostResponse {

    private int postId;
    private String postTitle;
    private String postContent;
    private String postImage;
    private User user;
    private Category category;
}
