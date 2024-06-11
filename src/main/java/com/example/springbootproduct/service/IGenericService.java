package com.example.springbootproduct.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);


}
