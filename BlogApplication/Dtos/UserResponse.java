package com.example.BlogApplication.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserResponse {

    private String name;
    private String email;
    private String about;
}
