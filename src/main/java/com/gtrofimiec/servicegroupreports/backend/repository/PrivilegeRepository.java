package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    @Override
    @NotNull
    List<Privilege> findAll();

    @Override
    @NotNull
    Optional<Privilege> findById(@NotNull Long id);

    @Override
    @NotNull
    Privilege save(Privilege privilege);

    @Override
    void deleteById(@NotNull Long id);
}