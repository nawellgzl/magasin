package com.nawell.magasin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.commandes.DeleteCommandeDTO;
import com.nawell.magasin.dtos.commandes.GetCommandesDTO;
import com.nawell.magasin.dtos.commandes.PostCommandeDTO;
import com.nawell.magasin.dtos.commandes.UpdateCommandeDTO;
import com.nawell.magasin.models.Commande;
import com.nawell.magasin.repositories.CommandeRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class CommandeService {

    CommandeRepository repository;
    ModelMapper mapper;

    public CommandeService(CommandeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetCommandesDTO> findAll() {
        List<Commande> commandes = this.repository.findAll();
        List<GetCommandesDTO> findCommandesDTOS = new ArrayList<>();
        commandes.forEach(commande -> findCommandesDTOS.add(mapper.map(commande, GetCommandesDTO.class)));
        return findCommandesDTOS;
    }

    public GetCommandesDTO save(PostCommandeDTO postCommandeDTO) {
        Commande commande = mapper.map(postCommandeDTO, Commande.class);
        return mapper.map(this.repository.save(commande), GetCommandesDTO.class);
    }

    public GetCommandesDTO update(UpdateCommandeDTO updateCommandeDTO) {
        Commande commande = mapper.map(updateCommandeDTO, Commande.class);
        return mapper.map(this.repository.save(commande), GetCommandesDTO.class);
    }

    public GetCommandesDTO findById(Long id) {
        return mapper.map(this.repository.findById(id).get(), GetCommandesDTO.class);
    }

    public void delete(DeleteCommandeDTO deleteCommandeDTO) {
        this.repository.delete(mapper.map(deleteCommandeDTO, Commande.class));
    }
}
