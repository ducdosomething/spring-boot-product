package com.example.springbootproduct.controller;

import com.example.springbootproduct.model.Product;
import com.example.springbootproduct.model.Type;
import com.example.springbootproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    // Show all product

    @GetMapping("")
    public ResponseEntity<Iterable<Product>> findAllProduct(@RequestParam(value = "name", required = false) String name) {

        List<Product> list;
        if (name != null) {
            list = productService.findProductsByName(name);
        } else {
            list = (List<Product>) productService.findAll();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<Iterable<Product>> findAllProduct() {
//        List<Product> listProduct = (List<Product>) productService.findAll();
//        if (listProduct.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(listProduct, HttpStatus.OK);
//    }

    // Find product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    // Tim theo type
    @GetMapping("/type/{id}")
    public ResponseEntity<List<Product>> findByType(Type type) {
        return new ResponseEntity<>(productService.findPlayersByType(type), HttpStatus.OK);
    }

    // Save product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }
}
