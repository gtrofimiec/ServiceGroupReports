package com.gtrofimiec.servicegroupreports.backend.facade;

import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.MonthlyReportDto;
import com.gtrofimiec.servicegroupreports.backend.mapper.MonthlyReportMapper;
import com.gtrofimiec.servicegroupreports.backend.service.MonthlyReportService;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class MonthlyReportFacade {

    private final MonthlyReportService monthlyReportService;
    private final MonthlyReportMapper monthlyReportMapper;

    public List<MonthlyReportDto> getAll() {
        return monthlyReportMapper.mapToMonthlyReportDtoList(monthlyReportService.getAll());
    }

    public MonthlyReportDto getOne(Long id) throws MonthlyReportNotFoundException {
        return monthlyReportMapper.mapToMonthlyReportDto(monthlyReportService.getOne(id));
    }

    public MonthlyReportDto save(MonthlyReportDto monthlyReportDto) throws MonthlyReportAlreadyExistsException {
        MonthlyReport newMonthlyReport = monthlyReportMapper.mapToMonthlyReport(monthlyReportDto);
        monthlyReportService.save(newMonthlyReport);
        return monthlyReportMapper.mapToMonthlyReportDto(newMonthlyReport);
    }

    public MonthlyReportDto update(Long id, MonthlyReportDto monthlyReportDto) throws MonthlyReportNotFoundException {
        MonthlyReport updatedMonthlyReport = monthlyReportMapper.mapToMonthlyReport(monthlyReportDto);
        updatedMonthlyReport.setId(id);
        monthlyReportService.update(updatedMonthlyReport);
        return monthlyReportMapper.mapToMonthlyReportDto(updatedMonthlyReport);
    }

    public void delete(Long id) throws MonthlyReportNotFoundException {
        monthlyReportService.delete(id);
    }
}