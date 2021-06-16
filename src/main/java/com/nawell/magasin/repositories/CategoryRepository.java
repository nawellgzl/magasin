package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}