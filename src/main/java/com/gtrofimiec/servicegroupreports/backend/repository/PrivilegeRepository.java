package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    @Override
    List<Privilege> findAll();

    @Override
    Optional<Privilege> findById(Long id);

    @Override
    Privilege save(Privilege privilege);

    @Override
    void deleteById(Long id);
}