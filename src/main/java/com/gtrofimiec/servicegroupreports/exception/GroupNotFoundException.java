package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GroupNotFoundException extends ResponseStatusException {

    public GroupNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Service group not found");
    }
}