package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface MonthlyReportRepository extends CrudRepository<MonthlyReport, Long> {

    @Override
    @NotNull
    List<MonthlyReport> findAll();

    @Override
    @NotNull
    Optional<MonthlyReport> findById(@NotNull Long id);

    @Override
    @NotNull
    MonthlyReport save(MonthlyReport monthlyReport);

    @Override
    void deleteById(@NotNull Long id);
}