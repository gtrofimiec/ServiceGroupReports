package com.gtrofimiec.servicegroupreports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MonthlyReportNotFoundException extends ResponseStatusException {

    public MonthlyReportNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Monthly report not found");
    }
}