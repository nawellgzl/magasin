package com.nawell.magasin.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name= "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

}
