package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Override
    @NotNull
    List<Group> findAll();

    @Override
    @NotNull
    Optional<Group> findById(@NotNull Long id);

    @Override
    @NotNull
    Group save(Group group);

    @Override
    void deleteById(@NotNull Long id);
}