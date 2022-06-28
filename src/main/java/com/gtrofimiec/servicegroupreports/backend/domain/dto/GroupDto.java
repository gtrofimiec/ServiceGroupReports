package com.gtrofimiec.servicegroupreports.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gtrofimiec.servicegroupreports.backend.domain.MonthlyReport;
import com.gtrofimiec.servicegroupreports.backend.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private List<Publisher> publishersList;
    @JsonProperty
    private List<MonthlyReport> monthlyReportsList;
    @JsonProperty
    private boolean deleted;
}