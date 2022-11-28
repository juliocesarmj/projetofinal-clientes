package com.projetofinal.application.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class AuthRequestDto {

    @Email(message = "Informe um email válido")
    private String email;

    @Size(min = 6, message = "A senha deve conter um mínimo de 6 caracteres")
    private String senha;
}
