package com.gtrofimiec.servicegroupreports.backend.facade;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.GroupDto;
import com.gtrofimiec.servicegroupreports.backend.mapper.GroupMapper;
import com.gtrofimiec.servicegroupreports.backend.service.GroupService;
import com.gtrofimiec.servicegroupreports.exception.GroupAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.GroupNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class GroupFacade {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    public List<GroupDto> getAll() {
        return groupMapper.mapToGroupDtoList(groupService.getAll());
    }

    public GroupDto getOne(Long id) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getOne(id));
    }

    public GroupDto save(GroupDto groupDto) throws GroupAlreadyExistsException {
        Group newGroup = groupMapper.mapToGroup(groupDto);
        groupService.save(newGroup);
        return groupMapper.mapToGroupDto(newGroup);
    }

    public GroupDto update(Long id, GroupDto groupDto) throws GroupNotFoundException {
        Group updatedGroup = groupMapper.mapToGroup(groupDto);
        updatedGroup.setId(id);
        groupService.update(updatedGroup);
        return groupMapper.mapToGroupDto(updatedGroup);
    }

    public void delete(Long id) throws GroupNotFoundException {
        groupService.delete(id);
    }
}