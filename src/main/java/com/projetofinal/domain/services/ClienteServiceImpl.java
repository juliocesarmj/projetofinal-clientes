package com.projetofinal.domain.services;

import com.google.gson.Gson;
import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.application.dtos.ClientePostDTO;
import com.projetofinal.domain.model.Cliente;
import com.projetofinal.domain.producer.EmailMessageProducer;
import com.projetofinal.domain.repositories.ClienteRepository;
import com.projetofinal.domain.services.excpetions.ArgumentoInvalidoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    private final EmailMessageProducer emailMessageProducer;

    @Override
    public ClienteGetDTO create(ClientePostDTO dto) {
        validaTelefone(dto.getTelefone());
        validaEmail(dto.getEmail());
        Cliente cliente = clienteRepository.save(Cliente.novo(dto));
        ClienteGetDTO clienteGetDTO = ClienteGetDTO.novo(cliente, "Cliente cadastrado com sucesso");
        try {
            this.emailMessageProducer.send(new Gson().toJson(clienteGetDTO));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return clienteGetDTO;
    }

    private void validaTelefone(String telefone) {
        Optional<Cliente> clienteOptional = clienteRepository.findByTelefone(telefone);

        if (clienteOptional.isPresent())
            throw new ArgumentoInvalidoException("Telefone já existe.");
    }

    private void validaEmail(String email) {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);

        if (clienteOptional.isPresent())
            throw new ArgumentoInvalidoException("Email já existe.");
    }
}
