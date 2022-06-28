package com.gtrofimiec.servicegroupreports.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MonthlyReportDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private Long publications;
    @JsonProperty
    private Long films;
    @JsonProperty
    private Long hours;
    @JsonProperty
    private Long returnVisits;
    @JsonProperty
    private Long studies;
    @JsonProperty
    private Group group;
    @JsonProperty
    private boolean deleted;
}