package com.nawell.magasin.dtos;

import com.nawell.magasin.models.Client;
import com.nawell.magasin.models.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCommandeDTO {
    private Client client;
    private List<Produit> produits;
}
