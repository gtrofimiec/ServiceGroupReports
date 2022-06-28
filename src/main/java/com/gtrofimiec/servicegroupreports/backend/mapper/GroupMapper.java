package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.GroupDto;
import com.gtrofimiec.servicegroupreports.exception.GroupNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public Group mapToGroup(final @NotNull GroupDto groupDto)
            throws GroupNotFoundException {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                groupDto.getPublishersList(),
                groupDto.getMonthlyReportsList(),
                groupDto.isDeleted()
        );
    }

    public GroupDto mapToGroupDto(final @NotNull Group group)
            throws GroupNotFoundException {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getPublishersList(),
                group.getMonthlyReportsList(),
                group.isDeleted()
        );
    }

    public List<GroupDto> mapToGroupDtoList(final @NotNull List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}