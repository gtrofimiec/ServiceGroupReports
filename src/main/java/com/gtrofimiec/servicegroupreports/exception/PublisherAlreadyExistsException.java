package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PublisherAlreadyExistsException extends ResponseStatusException {

    public PublisherAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Publisher already exists");
    }
}