package com.example.springsecurityexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityexample.Models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
