package com.example.springbootapp.controllers;

import com.example.springbootapp.model.Product;
import com.example.springbootapp.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/list")
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }

    @GetMapping("/list/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.getOneProduct(id);
    }
    //search?name=a
    @GetMapping("/search")
    public Product searchByName(@RequestParam String name){
        return service.getOneProductByName(name);
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product Product) {
        return service.createProduct(Product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product Product){
        return service.createProduct(Product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
    }
}
