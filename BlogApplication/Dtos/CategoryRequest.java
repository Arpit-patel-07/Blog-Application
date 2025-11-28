package com.example.BlogApplication.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryRequest {

    public String categoryTitle;
    public String categoryDescription;

}
