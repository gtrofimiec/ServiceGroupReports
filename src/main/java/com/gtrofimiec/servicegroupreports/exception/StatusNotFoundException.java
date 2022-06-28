package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StatusNotFoundException extends ResponseStatusException {

    public StatusNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Publisher status not found");
    }
}