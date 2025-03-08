package com.product.mapper;

import com.product.dto.ProductDto;
import com.product.entity.Category;
import com.product.entity.Product;

public class ProductMapper {
    //entity to DTO
//    public static ProductDto toProductDTO(Product product){
//        return new ProductDto(
//                product.getId(),
//                product.getName(),
//                product.getDescription(),
//                product.getPrice(),
//                product.getCategory().getId()
//        );
//    }
//
//    // DTO to entity
//    public static Product toProductEntity(ProductDto productDTO, Category category){
//        Product product = new Product();
//        product.setName(productDTO.getName());
//        product.setDescription(productDTO.getDescription());
//        product.setPrice(productDTO.getPrice());
//        product.setCategory(category);
//
//        return product;
//    }
}
