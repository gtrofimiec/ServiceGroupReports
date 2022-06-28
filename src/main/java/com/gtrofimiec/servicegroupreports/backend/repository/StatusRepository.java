package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    @Override
    List<Status> findAll();

    @Override
    Optional<Status> findById(Long id);

    @Override
    Status save(Status status);

    @Override
    void deleteById(Long id);
}