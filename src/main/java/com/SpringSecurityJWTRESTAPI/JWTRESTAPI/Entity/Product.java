package com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 128)
    @NotNull
    @Length(min = 5,max = 128)
    private String name;
    @NotNull
    private float price;
}
