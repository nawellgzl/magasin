package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
