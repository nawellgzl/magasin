package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Client;
import com.nawell.magasin.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
