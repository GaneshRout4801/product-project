package com.product.controller;


import com.product.dto.CategoryDto;
import com.product.exception.CategoryAlreadyExistException;
import com.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategories(@RequestBody CategoryDto categoryDto) throws CategoryAlreadyExistException {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = categoryService.getCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoriesById(@PathVariable Long id) {
        CategoryDto categoriesById = categoryService.getCategoriesById(id);
        return new ResponseEntity<CategoryDto>(categoriesById, HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoriesById(id);
        return new ResponseEntity<String>("Category with id " + id + " deleted successfully", HttpStatus.NO_CONTENT);
    }
}
