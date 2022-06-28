package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MonthlyReportAlreadyExistsException extends ResponseStatusException {

    public MonthlyReportAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Monthly report already exists");
    }
}