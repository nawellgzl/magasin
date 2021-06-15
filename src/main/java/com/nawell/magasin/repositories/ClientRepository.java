package com.nawell.magasin.repositories;

import com.nawell.magasin.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}