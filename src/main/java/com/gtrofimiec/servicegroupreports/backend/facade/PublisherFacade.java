package com.gtrofimiec.servicegroupreports.backend.facade;

import com.gtrofimiec.servicegroupreports.backend.domain.Publisher;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.PublisherDto;
import com.gtrofimiec.servicegroupreports.backend.mapper.PublisherMapper;
import com.gtrofimiec.servicegroupreports.backend.service.PublisherService;
import com.gtrofimiec.servicegroupreports.exception.PublisherAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PublisherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PublisherFacade {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    public List<PublisherDto> getAll() {
        return publisherMapper.mapToPublisherDtoList(publisherService.getAll());
    }

    public PublisherDto getOne(Long id) throws PublisherNotFoundException {
        return publisherMapper.mapToPublisherDto(publisherService.getOne(id));
    }

    public PublisherDto save(PublisherDto publisherDto) throws PublisherAlreadyExistsException {
        Publisher newPublisher = publisherMapper.mapToPublisher(publisherDto);
        publisherService.save(newPublisher);
        return publisherMapper.mapToPublisherDto(newPublisher);
    }

    public PublisherDto update(Long id, PublisherDto publisherDto) throws PublisherNotFoundException {
        Publisher updatedPublisher = publisherMapper.mapToPublisher(publisherDto);
        updatedPublisher.setId(id);
        publisherService.update(updatedPublisher);
        return publisherMapper.mapToPublisherDto(updatedPublisher);
    }

    public void delete(Long id) throws PublisherNotFoundException {
        publisherService.delete(id);
    }
}