package com.gtrofimiec.servicegroupreports.backend.facade;

import com.gtrofimiec.servicegroupreports.backend.domain.Status;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.StatusDto;
import com.gtrofimiec.servicegroupreports.backend.mapper.StatusMapper;
import com.gtrofimiec.servicegroupreports.backend.service.StatusService;
import com.gtrofimiec.servicegroupreports.exception.StatusAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.StatusNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class StatusFacade {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    public List<StatusDto> getAll() {
        return statusMapper.mapToStatusDtoList(statusService.getAll());
    }

    public StatusDto getOne(Long id) throws StatusNotFoundException {
        return statusMapper.mapToStatusDto(statusService.getOne(id));
    }

    public StatusDto save(StatusDto statusDto) throws StatusAlreadyExistsException {
        Status newStatus = statusMapper.mapToStatus(statusDto);
        statusService.save(newStatus);
        return statusMapper.mapToStatusDto(newStatus);
    }

    public StatusDto update(Long id, StatusDto statusDto) throws StatusAlreadyExistsException {
        Status updatedStatus = statusMapper.mapToStatus(statusDto);
        updatedStatus.setId(id);
        statusService.update(updatedStatus);
        return statusMapper.mapToStatusDto(updatedStatus);
    }

    public void delete(Long id) throws StatusNotFoundException {
        statusService.delete(id);
    }
}