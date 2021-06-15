package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
