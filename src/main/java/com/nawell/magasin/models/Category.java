package com.nawell.magasin.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;
}
