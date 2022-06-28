package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.StatusDto;
import com.gtrofimiec.servicegroupreports.exception.StatusNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class StatusMapper {

    public Status mapToPublisherStatus(final @NotNull StatusDto statusDto)
            throws StatusNotFoundException {
        return new Status(
                statusDto.getId(),
                statusDto.getName(),
                statusDto.isDeleted()
        );
    }

    public StatusDto mapToPublisherStatusDto(final @NotNull Status status)
            throws StatusNotFoundException {
        return new StatusDto(
                status.getId(),
                status.getName(),
                status.isDeleted()
        );
    }
}