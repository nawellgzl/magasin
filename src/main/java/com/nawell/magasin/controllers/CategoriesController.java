package com.nawell.magasin.controllers;

import com.nawell.magasin.dtos.categories.*;
import com.nawell.magasin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {

    @Autowired
    CategoryService service;

    @GetMapping
    public List<GetCategoriesDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public GetCategoriesDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public GetCategoryNameDTO save(@RequestBody PostCategoriesDTO postCategoriesDTO) {
        return this.service.save(postCategoriesDTO);
    }

    @PutMapping
    public GetCategoryNameDTO update(@RequestBody PutCategoryDTO putCategoryDTO) {
        return this.service.update(putCategoryDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCategoriesDTO deleteCategoriesDTO) {
        this.service.delete(deleteCategoriesDTO);
    }

}