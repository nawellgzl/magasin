package com.nawell.magasin.dtos.clients;

import com.nawell.magasin.models.Commande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClientsDTO {
    private Long id;
    private String name;
    private String firstname;
    private Collection<Commande> commandes;
}