package com.product.controller;

import com.product.dto.ProductDto;

import com.product.exception.ProductNotFoundException;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProducts(@RequestBody ProductDto productDto) {
        ProductDto product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

   @GetMapping("/{id}")
   public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Integer id,@RequestBody ProductDto productDto) throws ProductNotFoundException {
        ProductDto productDto1 = productService.updateProductById(id, productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.NOT_FOUND);
    }

}
