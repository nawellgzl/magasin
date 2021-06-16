package com.nawell.magasin.services;

import com.nawell.magasin.dtos.categories.*;
import com.nawell.magasin.models.Category;
import com.nawell.magasin.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    CategoryRepository repository;
    ModelMapper mapper;

    public CategoryService(CategoryRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GetCategoriesDTO> findAll() {
        List<Category> categories = this.repository.findAll();
        List<GetCategoriesDTO> categoriesDTOS = new ArrayList<>();
        categories.forEach(category -> categoriesDTOS.add(mapper.map(category, GetCategoriesDTO.class)));
        return categoriesDTOS;
    }

    public GetCategoryNameDTO save(PostCategoriesDTO postCategoriesDTO) {
        Category category = mapper.map(postCategoriesDTO, Category.class);
        return mapper.map(this.repository.save(category), GetCategoryNameDTO.class);
    }

    public GetCategoryNameDTO update(PutCategoryDTO putCategoryDTO) {
        Category category = mapper.map(putCategoryDTO, Category.class);
        return mapper.map(this.repository.save(category), GetCategoryNameDTO.class);
    }

    public GetCategoriesDTO findById(Long id) {
        return mapper.map(this.repository.findById(id).get(), GetCategoriesDTO.class);
    }

    public void delete(DeleteCategoriesDTO deleteCategoriesDTO) {
        this.repository.delete(mapper.map(deleteCategoriesDTO, Category.class));
    }
}
