package com.example.springbootproduct.service;

import com.example.springbootproduct.model.Product;
import com.example.springbootproduct.model.Type;

import java.util.List;

public interface IProductService extends IGenericService<Product> {
    // Viet tim product
    List<Product> findProductsByName(String name);

    // Tim theo type
    List<Product> findPlayersByType(Type type);


}
