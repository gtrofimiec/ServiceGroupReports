package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.PrivilegeDto;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeMapper {

    public Privilege mapToPrivilege(final @NotNull PrivilegeDto privilegeDto)
            throws PrivilegeNotFoundException {
        return new Privilege(
                privilegeDto.getId(),
                privilegeDto.getName(),
                privilegeDto.isDeleted()
        );
    }

    public PrivilegeDto mapToPrivilegeDto(final @NotNull Privilege privilege)
            throws PrivilegeNotFoundException {
        return new PrivilegeDto(
                privilege.getId(),
                privilege.getName(),
                privilege.isDeleted()
        );
    }

    public List<PrivilegeDto> mapToPrivilegeDtoList(final @NotNull List<Privilege> privilegeList) {
        return privilegeList.stream()
                .map(this::mapToPrivilegeDto)
                .collect(Collectors.toList());
    }
}