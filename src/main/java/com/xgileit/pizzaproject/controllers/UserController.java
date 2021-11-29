package com.xgileit.pizzaproject.controllers;

import com.xgileit.pizzaproject.entities.Cart;
import com.xgileit.pizzaproject.entities.PizzaMenu;
import com.xgileit.pizzaproject.entities.User;
import com.xgileit.pizzaproject.services.ChefService;
import com.xgileit.pizzaproject.services.CartService;
import com.xgileit.pizzaproject.services.PizzaMenuService;
import com.xgileit.pizzaproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    PizzaMenuService menuService;
    @Autowired
    CartService customerOrderService;
    @Autowired
    ChefService chefService;
    @Autowired
    UserService userService;

    /**
     * EndPoint for registering a user
     * */
    @PostMapping("/user/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * EndPoint for Logging a user in
     * */
    @PostMapping("/user/login")
    public String login(@RequestParam String email, String password) {
        return userService.login(email, password);
    }

    /**
     * EndPoint for Viewing the menu
     * returns List of pizzas
     * */
    @GetMapping("/viewMenu")
    public List<PizzaMenu> viewMenu() throws Exception {
        return menuService.viewMenu();
    }

    /**
     * EndPoint for Adding a pizza to the menu
     * returns List of pizzas
     * */
    List<PizzaMenu> menu = new ArrayList<>();
    @PostMapping("/menu/create")
    public List<PizzaMenu> addMenuItems(@RequestParam String userRole, @RequestBody PizzaMenu menu) throws Exception {
      return menuService.AddPizzaToMenu(userRole, menu);
    }

    /**
     * EndPoint for Updating the menu
     */
    @PutMapping("/menu/update")
    public List<PizzaMenu> updateMenu(@RequestParam String userRole, @RequestBody PizzaMenu pizza) throws Exception {
        return menuService.updatePizzaDetails(userRole, pizza);
    }

    /**
     * EndPoint for Deleting the menu
     * returns List of pizzas
     * */
    @DeleteMapping("/menu/delete")
    public String deleteMenuItem(String role, Long id) throws Exception {
        return menuService.deleteMenu(role, id);
    }

    /**
     * EndPoint for adding an item to cart
     * @Returns customer order
     * */
    @PostMapping("/cart/placeOrder")
    public Cart placingOrder(@RequestBody Cart customerOrder) throws Exception {
        return customerOrderService.createOrder(customerOrder);
    }

    /**
     * EndPoint for updating an order
     * @Returns customer order
     * */
    @PutMapping("/cart/updateOrder/{id}")
    public Cart updatingOrder(@PathVariable Long id, @RequestBody Cart customerOrder) throws Exception {
        return customerOrderService.updateOrder(id, customerOrder);
    }

    /**
     * EndPoint for Viewing an order
     * @Returns customer order
     * */
    @GetMapping("/cart/viewOrder/{id}")
    public List<Cart> viewOrder(@PathVariable Long id) throws Exception {
        return customerOrderService.viewOrder(id);
    }

    /**
     * EndPoint for deleting an order
     * @Returns customer order
     * */
    @DeleteMapping("/cart/deleteOrder/{id}")
    public String deleteOrder(@PathVariable Long id) throws Exception {
        return customerOrderService.deleteOrder(id);
    }

    /**
     * EndPoint for updating an order status
     * @Returns customer order
     * */
    @PutMapping("/chef/updateOrderStatus/{id}")
    public List<Cart> updateOrderStatus(@RequestBody Cart customerOrder) throws Exception {
        return chefService.updateOrderStatus(customerOrder);
    }

    /**
     * EndPoint for viewing order status
     * @Returns customer order
     * */
    @GetMapping("/chef/updateOrder/{id}")
    public List<Cart> viewOrderStatus(@PathVariable Long id) throws Exception {
        return chefService.viewOrder(id);
    }


}
