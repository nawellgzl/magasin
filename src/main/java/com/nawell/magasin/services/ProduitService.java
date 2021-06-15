package com.nawell.magasin.services;

import com.nawell.magasin.models.Commande;
import com.nawell.magasin.models.Produit;
import com.nawell.magasin.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProduitService {

    private JpaRepository<Produit, Integer> repository;

    public ProduitService(JpaRepository<Produit, Integer> repository){
        this.repository = repository;
    }

    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> findAll(){
        return this.produitRepository.findAll();
    }

    public Produit findById(int id){
        return this.produitRepository.findById(id).get();
    }


    public Produit save(Produit produit){
        return this.produitRepository.save(produit);
    }

    public Produit update(Produit produit) {
        return this.produitRepository.save(produit);
    }

    public void delete(int id) {
        this.produitRepository.deleteById(id);
    }

}
