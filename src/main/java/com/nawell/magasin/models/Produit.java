package com.nawell.magasin.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name= "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name= "category_id", referencedColumnName = "id")
    private Category category;

}
