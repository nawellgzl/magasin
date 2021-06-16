package com.nawell.magasin.dtos.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientDTO {
    private Long id;
    private String name;
    private String firstname;
}
