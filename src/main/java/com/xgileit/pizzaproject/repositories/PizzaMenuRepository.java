package com.xgileit.pizzaproject.repositories;

import com.xgileit.pizzaproject.entities.PizzaMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaMenuRepository extends JpaRepository<PizzaMenu, Long> {

}
