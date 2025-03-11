package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductDto {

    private Integer productId;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
    
    

    public ProductDto(Integer productId, String name, String description, Double price, Long categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
	}
    
    

	public ProductDto() {
		
	}



	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
