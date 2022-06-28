package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.MonthlyReportDto;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MonthlyReportMapper {

    public MonthlyReport mapToMonthlyReport(final @NotNull MonthlyReportDto monthlyReportDto)
            throws MonthlyReportNotFoundException {
        return new MonthlyReport(
                monthlyReportDto.getId(),
                monthlyReportDto.getDate(),
                monthlyReportDto.getPublications(),
                monthlyReportDto.getFilms(),
                monthlyReportDto.getHours(),
                monthlyReportDto.getReturnVisits(),
                monthlyReportDto.getStudies(),
                monthlyReportDto.getGroup(),
                monthlyReportDto.isDeleted()
        );
    }

    public MonthlyReportDto mapToMonthlyReportDto(final @NotNull MonthlyReport monthlyReport)
            throws MonthlyReportNotFoundException {
        return new MonthlyReportDto(
                monthlyReport.getId(),
                monthlyReport.getDate(),
                monthlyReport.getPublications(),
                monthlyReport.getFilms(),
                monthlyReport.getHours(),
                monthlyReport.getReturnVisits(),
                monthlyReport.getStudies(),
                monthlyReport.getGroup(),
                monthlyReport.isDeleted()
        );
    }
}