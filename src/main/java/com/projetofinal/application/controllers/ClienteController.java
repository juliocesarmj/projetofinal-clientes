package com.projetofinal.application.controllers;

import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.application.dtos.ClientePostDTO;
import com.projetofinal.domain.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
@Api("Clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping("/novo-cliente")
    @ApiOperation("Serviço de cadastro de clientes")
    public ResponseEntity<ClienteGetDTO> create(@RequestBody @Valid ClientePostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(dto));
    }
}
