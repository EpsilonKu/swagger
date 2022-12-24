package com.example.springsecurityexample.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springsecurityexample.Models.Basket;
import com.example.springsecurityexample.Models.MyUser;
import com.example.springsecurityexample.Models.Product;
import com.example.springsecurityexample.Models.Role;
import com.example.springsecurityexample.Models.RoleToUser;
import com.example.springsecurityexample.Models.Wishlist;
import com.example.springsecurityexample.Repos.BasketRepo;
import com.example.springsecurityexample.Repos.ProductRepo;
import com.example.springsecurityexample.Repos.WishlistRepo;
import com.example.springsecurityexample.Service.UserService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@Api(tags = "users")
@RequiredArgsConstructor // instead of autowired
public class UserController {
  private final UserService userService;

  @Autowired
  ProductRepo productRepo;

  @Autowired
  BasketRepo basketRepo;

  @Autowired
  WishlistRepo wishlistRepo;

  @GetMapping("users")
  public ResponseEntity<List<MyUser>> getUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @PostMapping("user/save")
  public ResponseEntity<MyUser> saveUser(@RequestBody MyUser user) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
    // fromCurrentContextPath() localhost
    return ResponseEntity.created(uri).body(userService.saveUser(user));
  }

  @PostMapping("role/save")
  public ResponseEntity<Role> saveUser(@RequestBody Role role) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
    // fromCurrentContextPath() localhost
    return ResponseEntity.created(uri).body(userService.saveRole(role));
  }

  @PostMapping("role/assigntouser")
  public ResponseEntity<?> assignRole(@RequestBody RoleToUser roleToUser) {
    userService.assignRole(roleToUser.getUsername(), roleToUser.getRoleName());
    return ResponseEntity.ok().build();
  }

  @PostMapping("product/save")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/save").toUriString());

    return ResponseEntity.created(uri).body(productRepo.save(product));
  }

  @GetMapping("products")
  public ResponseEntity<List<Product>> getProduct() {
    return ResponseEntity.ok().body(productRepo.findAll());
  }

  @PostMapping("basket/save")
  public ResponseEntity<Basket> saveBasket(@RequestBody Basket basket) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/basket/save").toUriString());

    return ResponseEntity.created(uri).body(basketRepo.save(basket));
  }

  @GetMapping("baskets")
  public ResponseEntity<List<Basket>> getBasket() {
    return ResponseEntity.ok().body(basketRepo.findAll());
  }

  @PostMapping("wishlist/save")
  public ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist wishlist) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/wishlist/save").toUriString());

    return ResponseEntity.created(uri).body(wishlistRepo.save(wishlist));
  }

  @GetMapping("wishlists")
  public ResponseEntity<List<Wishlist>> getWishlist() {
    return ResponseEntity.ok().body(wishlistRepo.findAll());
  }
}
