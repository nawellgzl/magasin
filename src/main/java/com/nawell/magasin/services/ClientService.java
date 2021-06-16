package com.nawell.magasin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.clients.DeleteClientDTO;
import com.nawell.magasin.dtos.clients.GetClientsDTO;
import com.nawell.magasin.dtos.clients.PostClientDTO;
import com.nawell.magasin.dtos.clients.UpdateClientDTO;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.repositories.ClientRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientService {

    ClientRepository repository;
    ModelMapper mapper;

    public ClientService(ClientRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetClientsDTO> findAll() {
        List<Client> clients = this.repository.findAll();
        List<GetClientsDTO> clientsDTOS = new ArrayList<>();
        clients.forEach(client -> clientsDTOS.add(mapper.map(client, GetClientsDTO.class)));
        return clientsDTOS;
    }

    public GetClientsDTO save(PostClientDTO postClientDTO) {
        Client client = mapper.map(postClientDTO, Client.class);
        return mapper.map(this.repository.save(client), GetClientsDTO.class);
    }

    public GetClientsDTO update(UpdateClientDTO updateClientDTO) {
        Client client = mapper.map(updateClientDTO, Client.class);
        return mapper.map(this.repository.save(client), GetClientsDTO.class);
    }

    public GetClientsDTO findById(Long id) {
        return mapper.map(this.repository.findById(id).get(), GetClientsDTO.class);
    }

    public void delete(DeleteClientDTO deleteClientDTO) {
        this.repository.delete(mapper.map(deleteClientDTO, Client.class));
    }
}