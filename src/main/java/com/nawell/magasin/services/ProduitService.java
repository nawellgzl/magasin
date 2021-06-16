package com.nawell.magasin.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.produits.DeleteProduitDTO;
import com.nawell.magasin.dtos.produits.GetProduitsDTO;
import com.nawell.magasin.dtos.produits.PostProduitDTO;
import com.nawell.magasin.dtos.produits.UpdateProduitDTO;
import com.nawell.magasin.models.Produit;
import com.nawell.magasin.repositories.ProduitRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProduitService {

    ProduitRepository repository;
    ModelMapper mapper;

    public ProduitService(ProduitRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetProduitsDTO> findAll() {
        List<Produit> produits = this.repository.findAll();
        List<GetProduitsDTO> produitsDTOS = new ArrayList<>();
        produits.forEach(produit -> produitsDTOS.add(mapper.map(produit, GetProduitsDTO.class)));
        return produitsDTOS;
    }

    public GetProduitsDTO save(PostProduitDTO postProduitDTO) {
        Produit produit = mapper.map(postProduitDTO, Produit.class);
        return mapper.map(this.repository.save(produit), GetProduitsDTO.class);
    }

    public GetProduitsDTO update(UpdateProduitDTO updateProduitDTO) {
        Produit produit = mapper.map(updateProduitDTO, Produit.class);
        return mapper.map(this.repository.save(produit), GetProduitsDTO.class);
    }

    public GetProduitsDTO findById(Long id) {
        return mapper.map(this.repository.findById(id).get(), GetProduitsDTO.class);
    }

    public void delete(DeleteProduitDTO deleteProduitDTO) {
        this.repository.delete(mapper.map(deleteProduitDTO, Produit.class));
    }
}
