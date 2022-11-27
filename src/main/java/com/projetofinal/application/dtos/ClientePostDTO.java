package com.projetofinal.application.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClientePostDTO {

    @NotBlank(message = "Informe um nome valido")
    private String nome;

    @Email(message = "Informe um email válido")
    private String email;

    @Size(min = 11, max = 11, message = "Informe um telefone válido")
    private String telefone;

    @Size(min = 6, message = "Mínimo de caracteres requeridos: 6")
    private String senha;
}
