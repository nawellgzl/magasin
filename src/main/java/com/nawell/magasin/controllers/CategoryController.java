package com.nawell.magasin.controllers;

import com.nawell.magasin.models.Category;
import com.nawell.magasin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("")
    public List<Category> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Category findById(@PathVariable int id){
        return this.service.findById(id);
    }

    @PostMapping("")
    public Category save(@RequestBody Category category){
        return this.service.save(category);
    }

    @PatchMapping("")
    public Category update(@RequestBody Category category){
        return this.service.update(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.service.delete(id);
    }

}
