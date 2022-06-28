package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StatusAlreadyExistsException extends ResponseStatusException {

    public StatusAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Publisher status already exists");
    }
}