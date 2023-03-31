package org.sid.equipedeveloperbank.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor

public class DeveloperDto {

    private Long id;
    private String name;
    private String email;

}
