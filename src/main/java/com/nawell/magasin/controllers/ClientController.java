package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.GetClientDTO;
import com.nawell.magasin.models.Category;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.services.CategoryService;
import com.nawell.magasin.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clients")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("")
    public List<GetClientDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public GetClientDTO findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/{name}")
    public Optional<Client> findByName(@PathVariable String name) {
        Optional<Client> client = service.findByName(name);
        return client;
    }

    @PostMapping("")
    public Client save(@RequestBody Client client){
        return this.service.save(client);
    }

    @PatchMapping("")
    public Client update(@RequestBody Client client){
        return this.service.update(client);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.service.delete(id);
    }

}

