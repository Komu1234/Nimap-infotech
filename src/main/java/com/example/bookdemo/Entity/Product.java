package com.example.bookdemo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "Product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;

    @Column(name = "p_name")
    private String pname;


    @Column(name = "p_price")
    private String p_price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;


    public Product() {
    }

    public Product(int p_id, String pname, String p_price, Category category1) {
        this.p_id = p_id;
        this.pname = pname;
        this.p_price = p_price;
        this.category = category1;
    }




    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [p_id=" + p_id + ", pname=" + pname + ", p_price=" + p_price + ", category1=" + category + "]";
    }
    
}
