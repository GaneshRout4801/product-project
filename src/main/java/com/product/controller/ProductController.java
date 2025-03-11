package com.product.controller;

import com.product.dto.ProductDto;

import com.product.exception.ProductNotFoundException;
import com.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name="Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Product REST API"
)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Operation(
            summary = "create products",
            description = "REST API to create products."
    )
    @PostMapping
    public ResponseEntity<ProductDto> createProducts(@RequestBody ProductDto productDto) {
        ProductDto product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Fetch all products",
            description = "REST API to fetch all products."
    )
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch  product by id",
            description = "REST API to fetch  product product by id."
    )
   @GetMapping("/{id}")
   public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @Operation(
            summary = "update product by id",
            description = "REST API to update product by id."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Integer id,@RequestBody ProductDto productDto) throws ProductNotFoundException {
        ProductDto productDto1 = productService.updateProductById(id, productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.OK);
    }

    @Operation(
            summary = "delete product by id",
            description = "REST API to delete product by id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.NOT_FOUND);
    }

}
