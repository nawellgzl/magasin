package com.nawell.magasin.dtos.produits;

import com.nawell.magasin.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProduitDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Category category;
}
