package com.example.BlogApplication.Services;

import ch.qos.logback.core.pattern.color.ConverterSupplierByClassName;
import com.example.BlogApplication.Converters.CategoryConverter;
import com.example.BlogApplication.Dtos.CategoryRequest;
import com.example.BlogApplication.Dtos.CategoryResponse;
import com.example.BlogApplication.Entities.Category;
import com.example.BlogApplication.Repositories.CategoryRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepositorie categoryRepositorie;

     public CategoryResponse createCategory(CategoryRequest categoryRequest){

         Category category = CategoryConverter.categoryRequestToCategory(categoryRequest);
         category.setAddedDate(new Date());
         Category saveCategory =  categoryRepositorie.save(category);
         return CategoryConverter.categoryToCategoryResponse(saveCategory);
     }

     public List<CategoryResponse> getAllCategory(){

         List<Category>  allCategories = categoryRepositorie.findAll();
         List<CategoryResponse> allCategoryResponses = new ArrayList<>();

         for(Category category : allCategories){
             CategoryResponse categoryResponse = CategoryConverter.categoryToCategoryResponse(category);
             allCategoryResponses.add(categoryResponse);
         }
         return  allCategoryResponses;
     }

    public CategoryResponse updateCategory(CategoryRequest categoryRequest , int categoryId){

         Category category = CategoryConverter.categoryRequestToCategory(categoryRequest);
         Optional<Category>  existingCategory = categoryRepositorie.findById(categoryId);
         if(existingCategory.isEmpty()){}
         Category newCategoryData = existingCategory.get();
         newCategoryData.setCategoryTitle(categoryRequest.getCategoryTitle());
         newCategoryData.setCategoryDescription(categoryRequest.getCategoryDescription());
         newCategoryData.setCategoryId(categoryId);
         Category saveCategory =  categoryRepositorie.save(newCategoryData);
         return CategoryConverter.categoryToCategoryResponse(saveCategory);
    }

    public void deleteCategory(int categoryId){
         categoryRepositorie.deleteById(categoryId);
    }
}
