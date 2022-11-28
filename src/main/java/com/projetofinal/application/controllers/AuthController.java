package com.projetofinal.application.controllers;

import com.projetofinal.application.dtos.AuthRequestDto;
import com.projetofinal.application.dtos.AuthResponseDto;
import com.projetofinal.domain.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping
    public ResponseEntity<AuthResponseDto> auth(@RequestBody @Valid AuthRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authService.auth(dto));
    }
}
