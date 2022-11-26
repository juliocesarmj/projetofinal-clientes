package com.projetofinal.application.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @PostMapping("/novo-cliente")
    public String create() {
        return "olá api de clientes";
    }
}
