package com.gtrofimiec.servicegroupreports.backend.service;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import com.gtrofimiec.servicegroupreports.backend.repository.PrivilegeRepository;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class PrivilegeService {

    public final PrivilegeRepository privilegeRepository;

    public List<Privilege> getAll() {
        return privilegeRepository.findAll().stream()
                .filter(p -> !p.isDeleted())
                .collect(Collectors.toList());
    }

    public Privilege getOne(final Long id) throws PrivilegeNotFoundException {
        return privilegeRepository.findById(id)
                .filter(p -> !p.isDeleted())
                .orElseThrow(PrivilegeNotFoundException::new);
    }

    public Privilege save(final @NotNull Privilege privilege) throws PrivilegeAlreadyExistsException {
        Long id = privilege.getId();
        if(id != null && privilegeRepository.existsById(id)) {
            throw new PrivilegeAlreadyExistsException();
        }
        return privilegeRepository.save(privilege);
    }

    public Privilege update(final @NotNull Privilege privilege) throws PrivilegeNotFoundException {
        Long id = privilege.getId();
        if(id == null || !privilegeRepository.existsById(id)) {
            throw new PrivilegeNotFoundException();
        }
        return privilegeRepository.save(privilege);
    }

    public void delete(final Long id) throws PrivilegeNotFoundException {
        Privilege privilege = privilegeRepository.findById(id)
                .orElseThrow(PrivilegeNotFoundException::new);
        privilege.setDeleted(true);
        privilegeRepository.save(privilege);
    }
}