package com.projetofinal.application.dtos;

import com.projetofinal.domain.model.Cliente;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthResponseDto {

    private String mensagem;
    private String accessToken;
    private Cliente cliente;

    public static AuthResponseDto novo(String mensagem, String token, Cliente cliente) {
        AuthResponseDto dto = new AuthResponseDto();
        dto.setMensagem(mensagem);
        dto.setAccessToken(token);
        dto.setCliente(cliente);

        return  dto;
    }
}
