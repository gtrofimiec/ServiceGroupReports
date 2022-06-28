package com.gtrofimiec.servicegroupreports.backend.service;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import com.gtrofimiec.servicegroupreports.backend.repository.GroupRepository;
import com.gtrofimiec.servicegroupreports.exception.GroupAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.GroupNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class GroupService {

    public final GroupRepository groupRepository;

    public List<Group> getAll() {
        return groupRepository.findAll().stream()
                .filter(g -> !g.isDeleted())
                .collect(Collectors.toList());
    }

    public Group getOne(final Long id) throws GroupNotFoundException {
        return groupRepository.findById(id)
                .filter(g -> !g.isDeleted())
                .orElseThrow(GroupNotFoundException::new);
    }

    public Group save(final @NotNull Group group) throws GroupAlreadyExistsException {
        Long id = group.getId();
        if(id != null && groupRepository.existsById(id)) {
            throw new GroupAlreadyExistsException();
        }
        return groupRepository.save(group);
    }

    public Group update(final @NotNull Group group) throws GroupNotFoundException {
        Long id = group.getId();
        if(id == null || !groupRepository.existsById(id)) {
            throw new GroupNotFoundException();
        }
        return groupRepository.save(group);
    }

    public void delete(final Long id) throws GroupNotFoundException {
        Group group = groupRepository.findById(id)
                .orElseThrow(GroupNotFoundException::new);
        group.setDeleted(true);
        groupRepository.save(group);
    }
}