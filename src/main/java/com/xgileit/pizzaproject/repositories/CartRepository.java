package com.xgileit.pizzaproject.repositories;

import com.xgileit.pizzaproject.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
List<Cart> findByOrderId(Long id);
}
