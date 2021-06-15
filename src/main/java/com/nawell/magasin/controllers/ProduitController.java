package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.GetProduitDTO;
import com.nawell.magasin.models.Produit;
import com.nawell.magasin.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produits")
@CrossOrigin
public class ProduitController {

    @Autowired
    private ProduitService service;

    @GetMapping("")
    public List<GetProduitDTO> findAll(){
        return this.service.findAll();
    }

    @GetMapping("/id/{id}")
    public GetProduitDTO findById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Produit> findByName(@PathVariable String name) {
        Optional<Produit> produit = service.findByName(name);
        return produit;
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
