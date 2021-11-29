package com.xgileit.pizzaproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long orderId;
    private String pizzaName;
    private int Quantity;
    private double price;
    private String orderStatus;
    /*@OneToMany
    List<OrderItems> orderList;*/

}
