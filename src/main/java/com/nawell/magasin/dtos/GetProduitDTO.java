package com.nawell.magasin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProduitDTO {
    private String name;
    private String description;
    private Double price;
}
