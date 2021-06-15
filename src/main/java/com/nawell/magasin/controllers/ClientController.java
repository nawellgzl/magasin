package com.nawell.magasin.controllers;

import com.nawell.magasin.models.Category;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.services.CategoryService;
import com.nawell.magasin.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("")
    public List<Client> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable int id){
        return this.service.findById(id);
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

