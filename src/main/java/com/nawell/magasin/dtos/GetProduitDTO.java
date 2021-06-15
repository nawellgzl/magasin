package com.nawell.magasin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProduitDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
}
