package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.produits.DeleteProduitDTO;
import com.nawell.magasin.dtos.produits.GetProduitsDTO;
import com.nawell.magasin.dtos.produits.PostProduitDTO;
import com.nawell.magasin.dtos.produits.UpdateProduitDTO;
import com.nawell.magasin.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
@CrossOrigin
public class ProduitsController {

    @Autowired
    ProduitService service;

    @GetMapping
    public List<GetProduitsDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetProduitsDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public GetProduitsDTO save(@RequestBody PostProduitDTO postProduitDTO) {
        return this.service.save(postProduitDTO);
    }

    @PutMapping
    public GetProduitsDTO update(@RequestBody UpdateProduitDTO updateProduitDTO) {
        return this.service.update(updateProduitDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteProduitDTO deleteProduitDTO) {
        this.service.delete(deleteProduitDTO);
    }

}
