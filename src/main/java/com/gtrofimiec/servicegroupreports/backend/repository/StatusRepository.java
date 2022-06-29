package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    @Override
    @NotNull
    List<Status> findAll();

    @Override
    @NotNull
    Optional<Status> findById(@NotNull Long id);

    @Override
    @NotNull
    Status save(Status status);

    @Override
    void deleteById(@NotNull Long id);
}