package com.gtrofimiec.servicegroupreports.backend.controller;

import com.gtrofimiec.servicegroupreports.backend.domain.dto.PublisherDto;
import com.gtrofimiec.servicegroupreports.backend.facade.PublisherFacade;
import com.gtrofimiec.servicegroupreports.exception.GroupAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PublisherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("v1/reports")
public class PublisherController {

    private final PublisherFacade publisherFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/publisher")
    public List<PublisherDto> getAll() {
        return publisherFacade.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/publisher/{id}")
    public PublisherDto getOne(@PathVariable("id") Long id) throws PublisherNotFoundException {
        return publisherFacade.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/publisher", consumes = APPLICATION_JSON_VALUE)
    public PublisherDto save(@RequestBody PublisherDto publisherDto) throws GroupAlreadyExistsException {
        return publisherFacade.save(publisherDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/publisher/{id}", consumes = APPLICATION_JSON_VALUE)
    public PublisherDto update(@PathVariable("id") Long id, @RequestBody PublisherDto publisherDto)
            throws PublisherNotFoundException {
        return publisherFacade.update(id, publisherDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/publisher/{id}")
    public void delete(@PathVariable("id") Long id) throws PublisherNotFoundException {
        publisherFacade.delete(id);
    }
}