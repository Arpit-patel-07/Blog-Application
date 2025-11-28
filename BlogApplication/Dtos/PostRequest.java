package com.example.BlogApplication.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostRequest {

    private String postTitle;
    private String postContent;
}
