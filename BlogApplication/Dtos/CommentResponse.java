package com.example.BlogApplication.Dtos;

import com.example.BlogApplication.Entities.Post;
import com.example.BlogApplication.Entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentResponse {

    private String comment;
    private User user;
    private Post post;
}
