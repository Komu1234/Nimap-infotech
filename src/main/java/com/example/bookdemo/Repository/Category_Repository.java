package com.example.bookdemo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookdemo.Entity.Category;

public interface Category_Repository extends JpaRepository<Category, Long> {
    
}
