package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PublisherNotFoundException extends ResponseStatusException {

    public PublisherNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Publisher not found");
    }
}