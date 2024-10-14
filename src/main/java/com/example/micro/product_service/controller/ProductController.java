package com.example.micro.product_service.controller;

import com.example.micro.product_service.dto.ProductRequest;
import com.example.micro.product_service.dto.ProductResponse;
import com.example.micro.product_service.model.Product;
import com.example.micro.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
         return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getProductrs()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())).toList();
    }

//    @GetMapping("/id")
//    @ResponseStatus
//    public List<ProductResponse> getProductById(@RequestParam BigDecimal id){
//
//    }

}
