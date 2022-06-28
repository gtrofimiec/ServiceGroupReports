package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.Privilege;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.PrivilegeDto;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeMapper {

    public Privilege mapToServicePrivilege(final @NotNull PrivilegeDto privilegeDto)
            throws PrivilegeNotFoundException {
        return new Privilege(
                privilegeDto.getId(),
                privilegeDto.getName(),
                privilegeDto.isDeleted()
        );
    }

    public PrivilegeDto mapToServicePrivilegeDto(final @NotNull Privilege privilege)
            throws PrivilegeNotFoundException {
        return new PrivilegeDto(
                privilege.getId(),
                privilege.getName(),
                privilege.isDeleted()
        );
    }
}