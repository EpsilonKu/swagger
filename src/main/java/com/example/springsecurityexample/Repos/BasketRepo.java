package com.example.springsecurityexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityexample.Models.Basket;

public interface BasketRepo extends JpaRepository<Basket, Long> {

}
