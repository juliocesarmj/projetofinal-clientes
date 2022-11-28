package com.projetofinal.application.dtos;

import com.projetofinal.domain.model.Cliente;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteGetDTO {

    private String nome;
    private String email;
    private String telefone;
    private String mensagem;

    public static ClienteGetDTO novo(Cliente cliente, String mensagem) {
        ClienteGetDTO dto = new ClienteGetDTO();
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        dto.setMensagem(mensagem);
        return dto;
    }
    public static ClienteGetDTO novo(Cliente cliente) {
        ClienteGetDTO dto = new ClienteGetDTO();
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        return dto;
    }
}
