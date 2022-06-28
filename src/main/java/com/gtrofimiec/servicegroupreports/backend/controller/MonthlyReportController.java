package com.gtrofimiec.servicegroupreports.backend.controller;

import com.gtrofimiec.servicegroupreports.backend.domain.dto.MonthlyReportDto;
import com.gtrofimiec.servicegroupreports.backend.facade.MonthlyReportFacade;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.MonthlyReportNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("v1/reports")
public class MonthlyReportController {

    private final MonthlyReportFacade monthlyReportFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/monthly-report")
    public List<MonthlyReportDto> getAll() {
        return monthlyReportFacade.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/monthly-report/{id}")
    public MonthlyReportDto getOne(@PathVariable("id") Long id) throws MonthlyReportNotFoundException {
        return monthlyReportFacade.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/monthly-report", consumes = APPLICATION_JSON_VALUE)
    public MonthlyReportDto save(@RequestBody MonthlyReportDto monthlyReportDto)
            throws MonthlyReportAlreadyExistsException {
        return monthlyReportFacade.save(monthlyReportDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/monthly-report/{id}", consumes = APPLICATION_JSON_VALUE)
    public MonthlyReportDto update(@PathVariable("id") Long id, @RequestBody MonthlyReportDto monthlyReportDto)
            throws MonthlyReportNotFoundException {
        return monthlyReportFacade.update(id, monthlyReportDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/monthly-report/{id}")
    public void delete(@PathVariable("id") Long id) throws MonthlyReportNotFoundException {
        monthlyReportFacade.delete(id);
    }
}