package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.clients.DeleteClientDTO;
import com.nawell.magasin.dtos.clients.GetClientsDTO;
import com.nawell.magasin.dtos.clients.PostClientDTO;
import com.nawell.magasin.dtos.clients.UpdateClientDTO;
import com.nawell.magasin.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("clients")
@CrossOrigin
public class ClientsController {

    @Autowired
    ClientService service;

    @GetMapping
    public List<GetClientsDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetClientsDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public GetClientsDTO save(@RequestBody PostClientDTO postClientDTO) {
        return this.service.save(postClientDTO);
    }

    @PutMapping
    public GetClientsDTO update(@RequestBody UpdateClientDTO updateClientDTO) {
        return this.service.update(updateClientDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteClientDTO deleteClientDTO) {
        this.service.delete(deleteClientDTO);
    }

}
