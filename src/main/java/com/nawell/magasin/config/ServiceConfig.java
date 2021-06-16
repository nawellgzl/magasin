package com.nawell.magasin.config;

import com.nawell.magasin.repositories.CategoryRepository;
import com.nawell.magasin.repositories.ClientRepository;
import com.nawell.magasin.repositories.CommandeRepository;
import com.nawell.magasin.repositories.ProduitRepository;
import com.nawell.magasin.services.CategoryService;
import com.nawell.magasin.services.ClientService;
import com.nawell.magasin.services.CommandeService;
import com.nawell.magasin.services.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CategoryService categoryService(CategoryRepository repository, ModelMapper mapper) {
        return new CategoryService(repository, mapper);
    }

    @Bean
    public ProduitService produitService(ProduitRepository repository, ModelMapper mapper) {
        return new ProduitService(repository, mapper);
    }

    @Bean
    public ClientService clientService(ClientRepository repository, ModelMapper mapper) {
        return new ClientService(repository, mapper);
    }

    @Bean
    public CommandeService commandeService(CommandeRepository repository, ModelMapper mapper) {
        return new CommandeService(repository, mapper);
    }

}
