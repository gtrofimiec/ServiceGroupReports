package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PrivilegeNotFoundException extends ResponseStatusException {

    public PrivilegeNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Service privilege not found");
    }
}