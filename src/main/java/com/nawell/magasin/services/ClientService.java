package com.nawell.magasin.services;

import com.nawell.magasin.models.Client;
import com.nawell.magasin.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ClientService {

    private JpaRepository<Client, Integer> repository;

    public ClientService(JpaRepository<Client, Integer> repository){
        this.repository = repository;
    }

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }

    public Client findById(int id){
        return this.clientRepository.findById(id).get();
    }

    public Client save(Client client){
        return this.clientRepository.save(client);
    }

    public Client update(Client client) {
        return this.clientRepository.save(client);
    }

    public void delete(int id) {
        this.clientRepository.deleteById(id);
    }


}
