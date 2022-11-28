package com.projetofinal.domain.services;

import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.application.dtos.ClientePostDTO;
import com.projetofinal.domain.model.Cliente;
import com.projetofinal.domain.repositories.ClienteRepository;
import com.projetofinal.domain.services.excpetions.ArgumentoInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteGetDTO create(ClientePostDTO dto) {
        validaTelefone(dto.getTelefone());
        validaEmail(dto.getEmail());
        return ClienteGetDTO.novo(clienteRepository.save(Cliente.novo(dto)), "Cliente cadastrado com sucesso");
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
