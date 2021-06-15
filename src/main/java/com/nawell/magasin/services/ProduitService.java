package com.nawell.magasin.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.GetProduitDTO;
import com.nawell.magasin.models.Produit;
import com.nawell.magasin.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProduitService {

    ProduitRepository repository;
    private ObjectMapper mapper;

    public ProduitService(ProduitRepository repository, ObjectMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<GetProduitDTO> findAll(){
        List<Produit> produits = this.repository.findAll();
        List<GetProduitDTO> getProduitDTOS = new ArrayList<>();
        produits.forEach(client -> {
            getProduitDTOS.add(
                    this.mapper.convertValue(client, GetProduitDTO.class)
            );
        });
        return getProduitDTOS;
    }

    public GetProduitDTO  findById(int id){
        return mapper.convertValue(this.repository.findById(id).get(), GetProduitDTO.class);
    }

    public Optional<Produit> findByName(String name) {
        return this.repository.findByName(name);
    }


    public Produit save(Produit produit){
        return this.repository.save(produit);
    }

    public Produit update(Produit produit) {
        return this.repository.save(produit);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }

}
