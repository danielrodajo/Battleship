package com.daniel.hundirflota.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDto {

    private Long id;

    private String email;
    
    private String name;
    
    private String surname;
}
