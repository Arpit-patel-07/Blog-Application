package com.example.BlogApplication.Converters;

import com.example.BlogApplication.Dtos.CategoryRequest;
import com.example.BlogApplication.Dtos.CategoryResponse;
import com.example.BlogApplication.Entities.Category;

public class CategoryConverter {

    public static Category categoryRequestToCategory(CategoryRequest categoryRequest){

        Category category = new Category();
        category.setCategoryDescription(categoryRequest.getCategoryDescription());
        category.setCategoryTitle(categoryRequest.getCategoryTitle());
        return category;
    }

    public static  CategoryResponse categoryToCategoryResponse(Category category){

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryDescription(category.getCategoryDescription());
        categoryResponse.setCategoryTitle(category.getCategoryTitle());
        return categoryResponse;
    }
}
