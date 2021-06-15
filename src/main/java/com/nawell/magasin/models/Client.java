package com.nawell.magasin.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name="firstname")
    private String firstname;

}
