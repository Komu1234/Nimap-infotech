package com.example.bookdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookdemo.Entity.Product;

public interface Product_Repository extends JpaRepository<Product,Integer>{

    

    
}
