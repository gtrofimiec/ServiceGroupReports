package com.gtrofimiec.servicegroupreports.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PublisherDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private Group group;
    @JsonProperty
    private Privilege privilege;
    @JsonProperty
    private Status status;
    @JsonProperty
    private boolean deleted;
}