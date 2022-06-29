package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.Publisher;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    @Override
    @NotNull
    List<Publisher> findAll();

    @Override
    @NotNull
    Optional<Publisher> findById(@NotNull Long id);

    @Override
    @NotNull
    Publisher save(Publisher publisher);

    @Override
    void deleteById(@NotNull Long id);
}