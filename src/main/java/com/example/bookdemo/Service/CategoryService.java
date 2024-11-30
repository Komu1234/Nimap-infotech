package com.example.bookdemo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.bookdemo.Entity.Category;

import com.example.bookdemo.Repository.Category_Repository;

@Service
public class CategoryService {
    @Autowired
    private Category_Repository categoryRepository;

    public List<Category> getCategories(int pageNumber,int pageSize) {
		
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		List<Category> list =categoryRepository.findAll(pageable).getContent();
		
		
		
		return list;
		
	}

    public String createCategory(Category category) {
       categoryRepository.save(category);
       return "Category is inserted";
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public String updateCategory(Long id, Category category) {
        Category categorydb = categoryRepository.findById(id).get();


        if(categorydb!= null){
            category.setCid(category.getCid());
            categoryRepository.save(category);
            return "Updated Successfully";
        }
        return "Category not found";
        
    }

    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);

        return "Deleted Successfully";
    }

    
}
