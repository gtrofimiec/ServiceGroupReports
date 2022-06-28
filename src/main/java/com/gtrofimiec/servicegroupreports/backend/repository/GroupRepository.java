package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(Long id);

    @Override
    Group save(Group group);

    @Override
    void deleteById(Long id);
}