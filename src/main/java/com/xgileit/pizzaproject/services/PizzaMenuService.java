package com.xgileit.pizzaproject.services;

import com.xgileit.pizzaproject.entities.PizzaMenu;
import com.xgileit.pizzaproject.repositories.PizzaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaMenuService {
    @Autowired
    PizzaMenuRepository menuRepo;
    List<PizzaMenu> menu = new ArrayList<>();

    /**
     * A service for adding kind of pizza to a menu
     * @param role represents the user's role
     * @param pizza information about the Pizza being added to the menu
     * */
    public List<PizzaMenu> AddPizzaToMenu (String role, PizzaMenu pizza) throws Exception {

           if (role.equalsIgnoreCase("Admin")) {
               menuRepo.save(pizza);
               menu = menuRepo.findAll();
               return menu;
           } else {
               throw new Exception("You do not have the rights to add items to the menu");
           }
    }

    /**
     * A service for updating pizza details on menu
     * @param role represents the user's role
     * @param pizza information about the Pizza being added to the menu
     * */
    public List<PizzaMenu> updatePizzaDetails (String role, PizzaMenu pizza) throws Exception {

            if (role.equalsIgnoreCase("Admin")) {
                menuRepo.save(pizza);
                menu = menuRepo.findAll();
                return menu;
            } else {
                throw new Exception("You do not have the rights to update items on the menu");
            }
    }

    /**
     * A service for viewing menu
     * */
    public List<PizzaMenu> viewMenu () throws Exception {
            menu = menuRepo.findAll();
            return menu;
    }

    /**
     * A service for updating pizza details on menu
     * @param role represents the user's role
     * @param id identification of the pizza to be deleted
     * */
    public String deleteMenu (String role, Long id) throws Exception {
        if (role.equalsIgnoreCase("Admin")) {
            menuRepo.findById(id);
            return "Successfully deleted";
        }
        else {
            throw new Exception("You do not have the rights to delete items on the menu");
        }

    }
}
