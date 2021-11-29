package com.xgileit.pizzaproject.services;

import com.xgileit.pizzaproject.entities.Cart;
import com.xgileit.pizzaproject.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
 @Autowired
 CartRepository customerOrderRepository;
List<Cart> customerOrderList;

 /**
  * A service for creating an order for pizza
  * @param customerOrder represents updated order info
  * */
 public Cart createOrder(Cart customerOrder){
   return customerOrderRepository.save(customerOrder);
 }

 /**
  * A service for updating the customer order
  * @param id identifies the order in the db
  * @param customerOrder represents updated order info
  * */
 public Cart updateOrder(Long id, Cart customerOrder){
   customerOrderRepository.save(customerOrder);
 return customerOrder;
 }

 /**
  * A service for viewing the customer order
  * @param id identifies the order in the db
  * */
 public List<Cart> viewOrder(Long id){
  customerOrderList = customerOrderRepository.findByOrderId(id);
  return customerOrderList;
 }

 /**
  * A service for cancelling the order
  * @param id identifies the order to be deleted
  * */
 public String deleteOrder(Long id){
  customerOrderRepository.deleteById(id);
  return "Successfully deleted order number: "+ id.toString();
 }

}
