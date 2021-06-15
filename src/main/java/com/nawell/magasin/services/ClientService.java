package com.nawell.magasin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawell.magasin.dtos.GetClientDTO;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientService {

    ClientRepository repository;

    private ObjectMapper mapper;

    public ClientService(ClientRepository repository, ObjectMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetClientDTO> findAll(){
        List<Client> clients = this.repository.findAll();
        List<GetClientDTO> getClientDTOS = new ArrayList<>();
        clients.forEach(client -> {
            getClientDTOS.add(
                    this.mapper.convertValue(client, GetClientDTO.class)
            );
        });
        return getClientDTOS;
    }

    public GetClientDTO findById(int id) {
        return mapper.convertValue(this.repository.findById(id).get(), GetClientDTO.class);
    }

    public Optional<Client> findByName(String name) {
        return this.repository.findByName(name);
    }

    public Client save(Client client){
        return this.repository.save(client);
    }

    public Client update(Client client) {
        return this.repository.save(client);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }


}
