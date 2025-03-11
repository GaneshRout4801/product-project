package com.product.service;

import com.product.dto.ProductDto;
import com.product.entity.Category;
import com.product.entity.Product;
import com.product.exception.CategoryNotFoundException;
import com.product.exception.ProductNotFoundException;
import com.product.mapper.ProductMapper;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    

    public ProductDto createProduct(ProductDto productDto) {
    	
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("category id is not exist"));
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        ProductDto map = modelMapper.map(savedProduct, ProductDto.class);
        return map;
   }
//    public ProductDto createProduct(ProductDto productDTO){
//
//        Category category= categoryRepository.findById(productDTO.getCategoryId())
//                .orElseThrow(()-> new RuntimeException("Category id: "
//                        + productDTO.getCategoryId() + " not found!"));
//
//        // DTO -> entity
//        Product product = ProductMapper.toProductEntity(productDTO, category);
//        product = productRepository.save(product);
//        // Entity -> DTO
//        
//        return ProductMapper.toProductDTO(product);
//
//    }


    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product,ProductDto.class)).toList();

        return productDtoList;
    }

    public ProductDto getProductById(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product id is not exist"));
        return modelMapper.map(product, ProductDto.class);
    }

    public ProductDto updateProductById(Integer id, ProductDto productDto) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product id is not exist"));
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("category id is not exist"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    public void deleteProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("product is not found"));
        productRepository.delete(product);
    }
}
