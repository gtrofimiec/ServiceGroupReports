package com.gtrofimiec.servicegroupreports.backend.service;

import com.gtrofimiec.servicegroupreports.backend.domain.Publisher;
import com.gtrofimiec.servicegroupreports.backend.repository.PublisherRepository;
import com.gtrofimiec.servicegroupreports.exception.PublisherAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PublisherNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public List<Publisher> getAll() {
        return publisherRepository.findAll().stream()
                .filter(p -> !p.isDeleted())
                .collect(Collectors.toList());
    }

    public Publisher getOne(final Long id) throws PublisherNotFoundException {
        return publisherRepository.findById(id)
                .filter(p -> !p.isDeleted())
                .orElseThrow(PublisherNotFoundException::new);
    }

    public Publisher save(final @NotNull Publisher publisher) throws PublisherAlreadyExistsException {
        Long id = publisher.getId();
        if(id != null && publisherRepository.existsById(id)) {
            throw  new PublisherAlreadyExistsException();
        }
        return publisherRepository.save(publisher);
    }

    public Publisher update(final @NotNull Publisher publisher) throws PublisherNotFoundException {
        Long id = publisher.getId();
        if(id == null || !publisherRepository.existsById(id)) {
            throw  new PublisherNotFoundException();
        }
        return publisherRepository.save(publisher);
    }

    public void delete(final Long id) throws PublisherNotFoundException {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(PublisherNotFoundException::new);
        publisher.setDeleted(true);
        publisherRepository.save(publisher);
    }
}