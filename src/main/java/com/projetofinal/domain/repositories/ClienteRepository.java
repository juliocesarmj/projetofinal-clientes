package com.projetofinal.domain.repositories;

import com.projetofinal.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    @Query("{telefone :  ?0}")
    Optional<Cliente> findByTelefone(String telefone);

    @Query("{email :  ?0}")
    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByEmailAndSenha(String email, String senha);
}
