package com.projetofinal.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetofinal.application.dtos.ClientePostDTO;
import com.projetofinal.infrastructure.utils.EncryptPassword;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    private String nome;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String telefone;

    @JsonIgnore
    private String senha;

    public static Cliente novo(ClientePostDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setSenha(EncryptPassword.passwordEncoder(dto.getSenha()));

        return cliente;
    }
}
