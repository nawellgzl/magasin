package com.nawell.magasin.dtos.commandes;

import com.nawell.magasin.models.Client;
import com.nawell.magasin.models.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCommandeDTO {
    private Long id;
    private Client client;
    private Collection<Produit> produits;
}
