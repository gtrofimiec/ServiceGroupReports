package com.gtrofimiec.servicegroupreports.backend.controller;

import com.gtrofimiec.servicegroupreports.backend.domain.dto.StatusDto;
import com.gtrofimiec.servicegroupreports.backend.facade.StatusFacade;
import com.gtrofimiec.servicegroupreports.exception.StatusAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.StatusNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("v1/reports")
public class StatusController {

    private final StatusFacade statusFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public List<StatusDto> getAll() {
        return statusFacade.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/status/{id}")
    public StatusDto getOne(@PathVariable("id") Long id) throws StatusNotFoundException {
        return statusFacade.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/status", consumes = APPLICATION_JSON_VALUE)
    public StatusDto save(@RequestBody StatusDto statusDto) throws StatusAlreadyExistsException {
        return statusFacade.save(statusDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/status/{id}", consumes = APPLICATION_JSON_VALUE)
    public StatusDto update(@PathVariable("id") Long id, @RequestBody StatusDto statusDto)
            throws StatusNotFoundException {
        return statusFacade.update(id, statusDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/status/{id}")
    public void delete(@PathVariable("id") Long id) throws StatusNotFoundException {
        statusFacade.delete(id);
    }
}