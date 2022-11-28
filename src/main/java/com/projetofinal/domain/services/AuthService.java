package com.projetofinal.domain.services;

import com.projetofinal.application.dtos.AuthRequestDto;
import com.projetofinal.application.dtos.AuthResponseDto;
import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.domain.model.Cliente;
import com.projetofinal.domain.repositories.ClienteRepository;
import com.projetofinal.domain.services.excpetions.ArgumentoInvalidoException;
import com.projetofinal.infrastructure.security.TokenAuthentication;
import com.projetofinal.infrastructure.utils.EncryptEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenAuthentication tokenAuthentication;
    private final ClienteRepository clienteRepository;

    public AuthResponseDto auth(AuthRequestDto dto) {
        Optional<Cliente> optionalCliente = clienteRepository.findByEmailAndSenha(dto.getEmail(), EncryptEncoder.getHashMd5(dto.getSenha()));

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            return AuthResponseDto.novo("Usuário autenticado", tokenAuthentication.generateToken(cliente.getEmail(), "ROLE_CLIENTE"), cliente);
        }
        throw new ArgumentoInvalidoException("Usuário ou senha inválidos");
    }
}
