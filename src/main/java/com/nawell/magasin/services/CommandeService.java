package com.nawell.magasin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.GetClientDTO;
import com.nawell.magasin.dtos.GetCommandeDTO;
import com.nawell.magasin.dtos.GetProduitDTO;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.models.Commande;
import com.nawell.magasin.models.Produit;
import com.nawell.magasin.repositories.CommandeRepository;
import com.nawell.magasin.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandeService {

    CommandeRepository repository;
    private ObjectMapper mapper;

    public CommandeService(CommandeRepository repository, ObjectMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<GetCommandeDTO> findAll(){
        List<Commande> commandes = this.repository.findAll();
        List<GetCommandeDTO> getCommandeDTOS = new ArrayList<>();
        commandes.forEach(commande -> {
            getCommandeDTOS.add(
                    this.mapper.convertValue(commande, GetCommandeDTO.class)
            );

        });
        return getCommandeDTOS;
    }

    public GetCommandeDTO findById(int id){
        return mapper.convertValue(this.repository.findById(id), GetCommandeDTO.class);
    }


    public Commande save(Commande commande){
        return this.repository.save(commande);
    }

    public Commande update(Commande commande) {
        return this.repository.save(commande);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }
}
