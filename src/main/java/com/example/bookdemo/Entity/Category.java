package com.example.bookdemo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Category")

public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @Column(name = "c_name")
    private String cname;

    @Column(name = "c_description")
    private  String cdescription; 

  
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    
    private List<Product> products;
    


    public Category() {
    }


    public Category(long cid, String cname, String cdescription, List<Product> products) {
        this.cid = cid;
        this.cname = cname;
        this.cdescription = cdescription;
        this.products = products;
    }
    


    public long getCid() {
        return cid;
    }


    public void setCid(long cid) {
        this.cid = cid;
    }


    public String getCname() {
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getCdescription() {
        return cdescription;
    }


    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }


    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Category [cid=" + cid + ", cname=" + cname + ", cdescription=" + cdescription + ", products=" + products
                + "]";
    }


    

    
    
}
