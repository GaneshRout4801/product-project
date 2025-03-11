package com.product.controller;


import com.product.dto.CategoryDto;
import com.product.exception.CategoryAlreadyExistException;
import com.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Category REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Category REST API"
)
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(
            summary = "create category",
            description = "REST API to create category."
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategories(@RequestBody CategoryDto categoryDto) throws CategoryAlreadyExistException {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
    }

    @Operation(
            summary = "fetch all category",
            description = "REST API to fetch all  category."
    )
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = categoryService.getCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }

    @Operation(
            summary = "fetch category by id",
            description = "REST API to fetch category by id."
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoriesById(@PathVariable Long id) {
        CategoryDto categoriesById = categoryService.getCategoriesById(id);
        return new ResponseEntity<CategoryDto>(categoriesById, HttpStatus.OK);
    }

    @Operation(
            summary = "delete category by id",
            description = "REST API to delete category by id."
    )
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoriesById(id);
        return new ResponseEntity<String>("Category with id " + id + " deleted successfully", HttpStatus.NO_CONTENT);
    }
}
