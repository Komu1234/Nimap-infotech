package com.example.bookdemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bookdemo.Entity.Product;
import com.example.bookdemo.Repository.Product_Repository;

@Service
public class ProductService {
    @Autowired
    private Product_Repository productRepository;

    public List<Product> getProducts(int pageNumber,int pageSize) {
		
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		List<Product> list =productRepository.findAll(pageable).getContent();
		return list;
		
	}

    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public String updateProduct(int id, Product product) {
        Product productdb = productRepository.findById(id).get();


        if(productdb!= null){
            product.setP_id(product.getP_id());
           productRepository.save(product);
            return "Updated Successfully";
        }
        return "product not found";
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
