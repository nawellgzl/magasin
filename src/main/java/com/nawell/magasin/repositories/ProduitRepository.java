package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    Optional<Produit> findByName(String name);
}
