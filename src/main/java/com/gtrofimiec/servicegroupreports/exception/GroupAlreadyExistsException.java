package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GroupAlreadyExistsException extends ResponseStatusException {

    public GroupAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Service group already exists");
    }
}