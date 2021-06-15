package com.nawell.magasin.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name= "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name="commande_has_produit",
            joinColumns = @JoinColumn(name="commande_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="produit_id", referencedColumnName = "id")
    )
    private List<Produit> produits;
}
