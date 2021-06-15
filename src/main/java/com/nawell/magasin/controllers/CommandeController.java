package com.nawell.magasin.controllers;

import com.nawell.magasin.models.Commande;
import com.nawell.magasin.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commandes")
@CrossOrigin
public class CommandeController {

    @Autowired
    private CommandeService service;

    @GetMapping("")
    public List<Commande> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Commande findById(@PathVariable int id) {
        return this.service.findById(id);
    }

    @PostMapping("")
    public Commande save(@RequestBody Commande commande) {
        return this.service.save(commande);
    }

    @PatchMapping("")
    public Commande update(@RequestBody Commande commande) {
        return this.service.update(commande);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.service.delete(id);
    }
}
