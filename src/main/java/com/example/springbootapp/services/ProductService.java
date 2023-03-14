package com.example.springbootapp.services;

import com.example.springbootapp.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public Product getOneProduct(Long id);
    Product getOneProductByName(String name);
    public Product createProduct(Product product);
    public boolean deleteProduct(Long id);
}
