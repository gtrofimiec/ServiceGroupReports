package com.gtrofimiec.servicegroupreports.backend.controller;

import com.gtrofimiec.servicegroupreports.backend.domain.dto.GroupDto;
import com.gtrofimiec.servicegroupreports.backend.facade.GroupFacade;
import com.gtrofimiec.servicegroupreports.exception.GroupAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.GroupNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("v1/reports")
public class GroupController {

    private final GroupFacade groupFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/group")
    public List<GroupDto> getAll() {
        return groupFacade.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/group/{id}")
    public GroupDto getOne(@PathVariable("id") Long id) throws GroupNotFoundException {
        return groupFacade.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/group", consumes = APPLICATION_JSON_VALUE)
    public GroupDto save(@RequestBody GroupDto groupDto) throws GroupAlreadyExistsException {
        return groupFacade.save(groupDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/group/{id}", consumes = APPLICATION_JSON_VALUE)
    public GroupDto update(@PathVariable("id") Long id, @RequestBody GroupDto groupDto)
            throws GroupNotFoundException {
        return groupFacade.update(id, groupDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/group/{id}")
    public void delete(@PathVariable("id") Long id) throws GroupNotFoundException {
        groupFacade.delete(id);
    }
}