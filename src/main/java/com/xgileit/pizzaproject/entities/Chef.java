package com.xgileit.pizzaproject.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Chef extends User implements Serializable {
}
