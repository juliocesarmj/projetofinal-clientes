package com.projetofinal.application.controllers.exceptions;

import lombok.Data;

@Data
public class StandardError {

    private int status;
    private String message;
    private String path;
    private long timestamp;
}
