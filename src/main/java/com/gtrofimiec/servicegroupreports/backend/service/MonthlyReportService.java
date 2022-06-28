package com.gtrofimiec.servicegroupreports.backend.service;

import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import com.gtrofimiec.servicegroupreports.backend.repository.MonthlyReportRepository;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class MonthlyReportService {

    private final MonthlyReportRepository monthlyReportRepository;

    public List<MonthlyReport> getAll() {
        return monthlyReportRepository.findAll().stream()
                .filter(mr -> !mr.isDeleted())
                .collect(Collectors.toList());
    }

    public MonthlyReport getOne(final Long id) throws MonthlyReportNotFoundException {
        return monthlyReportRepository.findById(id)
                .filter(mr -> !mr.isDeleted())
                .orElseThrow(MonthlyReportNotFoundException::new);
    }

    public MonthlyReport save(final @NotNull MonthlyReport monthlyReport) throws MonthlyReportAlreadyExistsException {
        Long id = monthlyReport.getId();
        if(id != null && monthlyReportRepository.existsById(id)) {
            throw new MonthlyReportAlreadyExistsException();
        }
        return monthlyReportRepository.save(monthlyReport);
    }

    public MonthlyReport update(final @NotNull MonthlyReport monthlyReport) throws MonthlyReportNotFoundException {
        Long id = monthlyReport.getId();
        if(id == null || !monthlyReportRepository.existsById(id)) {
            throw new MonthlyReportNotFoundException();
        }
        return monthlyReportRepository.save(monthlyReport);
    }

    public void delete(final Long id) throws MonthlyReportNotFoundException {
        MonthlyReport monthlyReport = monthlyReportRepository.findById(id)
                .orElseThrow(MonthlyReportNotFoundException::new);
        monthlyReport.setDeleted(true);
        monthlyReportRepository.save(monthlyReport);
    }
}