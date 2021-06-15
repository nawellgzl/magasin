package com.nawell.magasin.services;

import com.nawell.magasin.models.Category;
import com.nawell.magasin.models.Client;
import com.nawell.magasin.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class CategoryService {

    private JpaRepository<Category, Integer> repository;

    public CategoryService(JpaRepository<Category, Integer> repository){
        this.repository = repository;
    }

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Category findById(int id){
        return this.categoryRepository.findById(id).get();
    }


    public Category save(Category category){
        return this.categoryRepository.save(category);
    }

    public Category update(Category category) {
        return this.categoryRepository.save(category);
    }

    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }

}
