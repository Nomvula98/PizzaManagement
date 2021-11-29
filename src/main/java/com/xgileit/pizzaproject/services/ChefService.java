package com.xgileit.pizzaproject.services;

import com.xgileit.pizzaproject.entities.Cart;
import com.xgileit.pizzaproject.repositories.ChefRepository;
import com.xgileit.pizzaproject.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class ChefService {
    @Autowired
    ChefRepository chefRepository;
    @Autowired
    CartRepository customerOrderRepository;

    List<Cart> customerOrderList;
    /**
     * A service for updating the customer order status
     * @param customerOrder represents updated order info
     * */
    public List<Cart> updateOrderStatus(Cart customerOrder){
        List<Cart> listOfOrders = new LinkedList<>();
        customerOrder.setOrderStatus(customerOrder.getOrderStatus());
        customerOrderRepository.save(customerOrder);
        listOfOrders = customerOrderRepository.findAll();
        if (listOfOrders.get(0).getOrderStatus().equalsIgnoreCase("Finished")){
            customerOrderRepository.delete(listOfOrders.get(0));
        }
         return listOfOrders;
    }

    /**
     * A service for viewing the order of customer
     * @param id identifies the specific order to be viewed
     * */
    public List<Cart> viewOrder(Long id){
        customerOrderList = customerOrderRepository.findByOrderId(id);
        return customerOrderList;
    }
}
