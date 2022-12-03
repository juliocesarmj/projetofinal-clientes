package com.projetofinal.domain.utils;

import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.application.dtos.EmailMessageDTO;

public abstract class ClienteEmailHelper {

    public static EmailMessageDTO createProducerEmail(ClienteGetDTO cliente) {
        String to = cliente.getEmail();
        String subject = "Parabéns, sua conta foi criada com sucesso!";
        String body = "Olá ".concat(cliente.getNome())
                .concat("\n\nSua conta de cliente foi cadastrada com sucesso em nossa plataforma de atendimento.")
                .concat("\nSeus dados são:")
                .concat("\nNome: ").concat(cliente.getNome())
                .concat("\nTelefone: ").concat(cliente.getTelefone())
                .concat("\nAtt")
                .concat("\nEquipe Moraes");
        return EmailMessageDTO.novo(to, subject, body);
    }
}
