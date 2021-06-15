package com.nawell.magasin.services;

import com.nawell.magasin.models.Client;
import com.nawell.magasin.models.Commande;
import com.nawell.magasin.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class CommandeService {

    private JpaRepository<Commande, Integer> repository;

    public CommandeService(JpaRepository<Commande, Integer> repository){
        this.repository = repository;
    }

    @Autowired
    CommandeRepository commandeRepository;

    public List<Commande> findAll(){
        return this.commandeRepository.findAll();
    }

    public Commande findById(int id){
        return this.commandeRepository.findById(id).get();
    }


    public Commande save(Commande commande){
        return this.commandeRepository.save(commande);
    }

    public Commande update(Commande commande) {
        return this.commandeRepository.save(commande);
    }

    public void delete(int id) {
        this.commandeRepository.deleteById(id);
    }
}
