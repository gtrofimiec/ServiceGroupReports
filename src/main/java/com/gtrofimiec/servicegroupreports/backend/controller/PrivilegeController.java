package com.gtrofimiec.servicegroupreports.backend.controller;

import com.gtrofimiec.servicegroupreports.backend.domain.dto.PrivilegeDto;
import com.gtrofimiec.servicegroupreports.backend.facade.PrivilegeFacade;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeAlreadyExistsException;
import com.gtrofimiec.servicegroupreports.exception.PrivilegeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("v1/reports")
public class PrivilegeController {

    private final PrivilegeFacade privilegeFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/privilege")
    public List<PrivilegeDto> getAll() {
        return privilegeFacade.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/privilege/{id}")
    public PrivilegeDto getOne(@PathVariable("id") Long id) throws PrivilegeNotFoundException {
        return privilegeFacade.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/privilege", consumes = APPLICATION_JSON_VALUE)
    public PrivilegeDto save(@RequestBody PrivilegeDto privilegeDto) throws PrivilegeAlreadyExistsException {
        return privilegeFacade.save(privilegeDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/privilege/{id}", consumes = APPLICATION_JSON_VALUE)
    public PrivilegeDto update(@PathVariable("id") Long id, @RequestBody PrivilegeDto privilegeDto)
            throws PrivilegeNotFoundException {
        return privilegeFacade.update(id, privilegeDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/privilege/{id}")
    public void delete(@PathVariable("id") Long id) throws PrivilegeNotFoundException {
        privilegeFacade.delete(id);
    }
}
