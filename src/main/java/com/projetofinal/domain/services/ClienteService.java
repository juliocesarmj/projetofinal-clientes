package com.projetofinal.domain.services;

import com.projetofinal.application.dtos.ClienteGetDTO;
import com.projetofinal.application.dtos.ClientePostDTO;

public interface ClienteService {

    ClienteGetDTO create(ClientePostDTO dto);
}
