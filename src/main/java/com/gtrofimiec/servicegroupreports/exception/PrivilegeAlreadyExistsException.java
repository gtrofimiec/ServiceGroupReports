package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PrivilegeAlreadyExistsException extends ResponseStatusException {

    public PrivilegeAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Service privilege already exists");
    }
}