package com.xgileit.pizzaproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PizzaMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long pizzaId;
    private String pizzaName;
    private String pizzaDesc;
    private String pizzaPrice;
    private String pizzaStatus;


}
