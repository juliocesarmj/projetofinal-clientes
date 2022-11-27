package com.projetofinal.domain.services.excpetions;

public class ArgumentoInvalidoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ArgumentoInvalidoException(String message) {
        super(message);
    }
}
