package com.xgileit.pizzaproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String userName;
    private String userSurname;
    @Column(nullable = false, unique = true)
    private String userEmail;
    private String userCellNo;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userRole;


}
