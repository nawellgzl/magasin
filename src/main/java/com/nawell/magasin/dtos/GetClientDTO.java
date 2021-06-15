package com.nawell.magasin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientDTO {
    private String name;
    private String firstname;
}
