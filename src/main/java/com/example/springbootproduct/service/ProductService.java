package com.example.springbootproduct.service;

import com.example.springbootproduct.model.Product;
import com.example.springbootproduct.model.Type;
import com.example.springbootproduct.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    // Doc het
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    // Tim theo ID
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    //Viet timf kiem product
    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findPlayersByType(Type type) {
        List<Product> lists = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for (Product p : list) {
            if (p.getType().getId() == type.getId()) {
                lists.add(p);
            }
        }
        return lists;
    }



}
