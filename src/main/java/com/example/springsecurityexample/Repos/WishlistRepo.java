package com.example.springsecurityexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityexample.Models.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {

}
