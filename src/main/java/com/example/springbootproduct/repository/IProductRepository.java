package com.example.springbootproduct.repository;

import com.example.springbootproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    //Viet query tim kiem
    @Query("select p from Product  p where p.name like %?1%")
    List<Product> findByName(String name);


}
