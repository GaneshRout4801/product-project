package com.product.service;

import com.product.dto.CategoryDto;
import com.product.entity.Category;
import com.product.exception.CategoryAlreadyExistException;
import com.product.exception.CategoryNotFoundException;
import com.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private  ModelMapper modelMapper;

    public CategoryDto createCategory(CategoryDto categoryDto) throws CategoryAlreadyExistException {
        Optional<Category> byName = categoryRepository.findByName(categoryDto.getName());
        if (byName.isPresent()) {
            throw new CategoryAlreadyExistException("Category with the same name already exists");
        }
        Category category = modelMapper.map(categoryDto, Category.class);
        Category category1 = categoryRepository.save(category);
        CategoryDto map = modelMapper.map(category1, CategoryDto.class);

        return map;
    }

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
       List<CategoryDto> categoryDtoList= categories.stream()
               .map(category->modelMapper.map(category, CategoryDto.class))
                .toList();
        return categoryDtoList;
    }


    public CategoryDto getCategoriesById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    public void deleteCategoriesById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }
}
