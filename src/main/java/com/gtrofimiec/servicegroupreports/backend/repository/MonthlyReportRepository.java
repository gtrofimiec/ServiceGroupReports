package com.gtrofimiec.servicegroupreports.backend.repository;

import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface MonthlyReportRepository extends CrudRepository<MonthlyReport, Long> {

    @Override
    List<MonthlyReport> findAll();

    @Override
    Optional<MonthlyReport> findById(Long id);

    @Override
    MonthlyReport save(MonthlyReport monthlyReport);

    @Override
    void deleteById(Long id);
}