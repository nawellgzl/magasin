package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.commandes.DeleteCommandeDTO;
import com.nawell.magasin.dtos.commandes.GetCommandesDTO;
import com.nawell.magasin.dtos.commandes.PostCommandeDTO;
import com.nawell.magasin.dtos.commandes.UpdateCommandeDTO;
import com.nawell.magasin.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commandes")
@CrossOrigin
public class CommandesController {

    @Autowired
    CommandeService service;

    @GetMapping
    public List<GetCommandesDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetCommandesDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public GetCommandesDTO save(@RequestBody PostCommandeDTO postCommandeDTO) {
        return this.service.save(postCommandeDTO);
    }

    @PutMapping
    public GetCommandesDTO update(@RequestBody UpdateCommandeDTO updateCommandeDTO) {
        return this.service.update(updateCommandeDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCommandeDTO deleteCommandeDTO) {
        this.service.delete(deleteCommandeDTO);
    }

}