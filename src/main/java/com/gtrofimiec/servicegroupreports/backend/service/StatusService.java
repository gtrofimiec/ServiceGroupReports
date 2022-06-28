package com.gtrofimiec.servicegroupreports.backend.service;

import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import com.gtrofimiec.servicegroupreports.backend.repository.StatusRepository;
import com.gtrofimiec.servicegroupreports.exception.StatusAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.StatusNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> getAll() {
        return statusRepository.findAll().stream()
                .filter(ps -> !ps.isDeleted())
                .collect(Collectors.toList());
    }

    public Status getOne(final Long id) throws StatusNotFoundException {
        return statusRepository.findById(id)
                .filter(ps -> !ps.isDeleted())
                .orElseThrow(StatusNotFoundException::new);
    }

    public Status save(final @NotNull Status status)
            throws StatusAlreadyExistsException {
        Long id = status.getId();
        if(id != null && statusRepository.existsById(id)) {
            throw new StatusAlreadyExistsException();
        }
        return statusRepository.save(status);
    }

    public Status update(final @NotNull Status status)
            throws StatusNotFoundException {
        Long id = status.getId();
        if(id == null || !statusRepository.existsById(id)) {
            throw new StatusNotFoundException();
        }
        return statusRepository.save(status);
    }

    public void delete(final Long id) throws StatusNotFoundException {
        Status status = statusRepository.findById(id)
                .orElseThrow(StatusNotFoundException::new);
        status.setDeleted(true);
        statusRepository.save(status);
    }
}