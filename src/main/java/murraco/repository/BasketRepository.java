package murraco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import murraco.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
