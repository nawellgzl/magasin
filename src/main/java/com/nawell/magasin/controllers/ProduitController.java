package com.nawell.magasin.controllers;

import com.nawell.magasin.models.Produit;
import com.nawell.magasin.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
@CrossOrigin
public class ProduitController {

    @Autowired
    private ProduitService service;

    @GetMapping("")
    public List<Produit> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Produit findById(@PathVariable int id){
        return this.service.findById(id);
    }

    @PostMapping("")
    public Produit save(@RequestBody Produit produit){
        return this.service.save(produit);
    }

    @PatchMapping("")
    public Produit update(@RequestBody Produit produit){
        return this.service.update(produit);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.service.delete(id);
    }

}
