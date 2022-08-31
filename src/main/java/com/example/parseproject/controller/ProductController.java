package com.example.parseproject.controller;

import com.example.parseproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.parseproject.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        Iterable<Product> result = productRepository.findAll();
        List<Product> productsList = new ArrayList<>();
        result.forEach(productsList::add);
        return productsList;
    }

    @DeleteMapping(value = "/product/{id}", produces = "application/json; charset=utf-8")
    public String deleteProduct(@PathVariable String id) {
        Boolean result = productRepository.existsById(id);
        productRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product newProduct)
    {
        String id = String.valueOf(new Random().nextInt());
        Product prod = new Product(id, newProduct.getName(), newProduct.getPrice());
        productRepository.save(prod);
        return prod;
    }
}
