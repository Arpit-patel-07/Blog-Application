package com.example.BlogApplication.Controllers;

import com.example.BlogApplication.Dtos.CategoryRequest;
import com.example.BlogApplication.Dtos.CategoryResponse;
import com.example.BlogApplication.Entities.Category;
import com.example.BlogApplication.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestParam("categoryId") int categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryRequest categoryRequest ,@RequestParam("categoryId") int categoryId){
        CategoryResponse categoryResponse =  categoryService.updateCategory(categoryRequest,categoryId);
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponse>> getAllCategory(){
        List<CategoryResponse> allCategoryResponse =  categoryService.getAllCategory();
        return new ResponseEntity<>(allCategoryResponse,HttpStatus.OK);
    }
}
