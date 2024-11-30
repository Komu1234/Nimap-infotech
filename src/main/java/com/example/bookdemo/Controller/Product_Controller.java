package com.example.bookdemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookdemo.Entity.Product;
import com.example.bookdemo.Service.ProductService;

@RestController
@RequestMapping("/products")
public class Product_Controller {
    
    @Autowired
    ProductService productService;
    

    @GetMapping
    public List<Product> getCategory(@RequestParam(defaultValue = "3") int page,
                                       @RequestParam(defaultValue = "7") int size) {
    	
        return productService.getProducts(page - 1, size);
        
       
    }
    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
        
    }

    @GetMapping("/{id}")
    public Optional<Product> getCategoryById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
