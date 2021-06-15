package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByName(String name);
}