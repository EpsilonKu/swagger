package murraco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import murraco.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
