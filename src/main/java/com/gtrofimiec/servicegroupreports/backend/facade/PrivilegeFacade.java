package com.gtrofimiec.servicegroupreports.backend.facade;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.PrivilegeDto;
import com.gtrofimiec.servicegroupreports.backend.mapper.PrivilegeMapper;
import com.gtrofimiec.servicegroupreports.backend.service.PrivilegeService;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PrivilegeFacade {

    private final PrivilegeService privilegeService;
    private final PrivilegeMapper privilegeMapper;

    public List<PrivilegeDto> getAll() {
        return privilegeMapper.mapToPrivilegeDtoList(privilegeService.getAll());
    }

    public PrivilegeDto getOne(Long id) throws PrivilegeNotFoundException {
        return privilegeMapper.mapToPrivilegeDto(privilegeService.getOne(id));
    }

    public PrivilegeDto save(PrivilegeDto privilegeDto) throws PrivilegeAlreadyExistsException {
        Privilege newPrivilege = privilegeMapper.mapToPrivilege(privilegeDto);
        privilegeService.save(newPrivilege);
        return privilegeMapper.mapToPrivilegeDto(newPrivilege);
    }

    public PrivilegeDto update(Long id, PrivilegeDto privilegeDto) throws PrivilegeNotFoundException {
        Privilege updatedPrivilege = privilegeMapper.mapToPrivilege(privilegeDto);
        updatedPrivilege.setId(id);
        privilegeService.update(updatedPrivilege);
        return privilegeMapper.mapToPrivilegeDto(updatedPrivilege);
    }

    public void delete(Long id) throws PrivilegeNotFoundException {
        privilegeService.delete(id);
    }
}