package com.product.service;

import com.product.dto.CategoryDto;
import com.product.entity.Category;
import com.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private  ModelMapper modelMapper;

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category category1 = categoryRepository.save(category);
        CategoryDto map = modelMapper.map(category1, CategoryDto.class);

        return map;
    }
}
