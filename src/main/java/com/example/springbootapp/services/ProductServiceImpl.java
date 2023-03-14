package com.example.springbootapp.services;

import com.example.springbootapp.model.Product;
import com.example.springbootapp.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    @Getter @Setter private ProductRepository repository;
    private List<Product> todos ;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product getOneProduct(Long id){
        return repository.findById(id).get();
    }

    public Product getOneProductByName(String name){
        todos = repository.findAll();
        return todos.stream().filter(result -> result.getProductName().equals(name)).findAny().orElse(null);
    }

    public Product createProduct(Product product){return repository.save(product);}

    public boolean deleteProduct(Long id){
        repository.deleteById(id);
        return true;
    }
}
