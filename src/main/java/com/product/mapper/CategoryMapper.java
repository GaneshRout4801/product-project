package com.product.mapper;

import com.product.dto.CategoryDto;
import com.product.entity.Category;
import lombok.RequiredArgsConstructor;

public class CategoryMapper {

//
//    public static CategoryDto toCategoryDTO(Category category){
//        if(category == null){
//            return null;
//        }
//        CategoryDto categoryDTO = new CategoryDto();
//
//        categoryDTO.setId(category.getId());
//        categoryDTO.setName(category.getName());
//        categoryDTO.setProducts(category.getProducts().stream()
//                .map(ProductMapper::toProductDTO).toList());
//        return categoryDTO;
//    }
//    public static Category toCategoryEntity(CategoryDto categoryDTO){
//        Category category = new Category();
//        category.setName(categoryDTO.getName());
//        return category;
//    }
}
