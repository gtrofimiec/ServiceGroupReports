package com.gtrofimiec.servicegroupreports.domain;

import com.gtrofimiec.servicegroupreports.backend.domain.Group;
import com.gtrofimiec.servicegroupreports.backend.repository.GroupRepository;
import com.gtrofimiec.servicegroupreports.backend.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {

    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldFindAllGroups() {

        // Given
        long currentNumberOfGroups = groupService.getAll().size();
        Group group1 = new Group();
        Group group2 = new Group();

        // When
        groupService.save(group1);
        groupService.save(group2);
        long availableGroups = groupService.getAll().size();

        // Then
        assertEquals(currentNumberOfGroups + 2, availableGroups);
    }

    @Test
    public void shouldFindGroupById() {

        // Given
        Group group1 = new Group();
        Group group2 = new Group();

        // When
        groupService.save(group1);
        groupService.save(group2);
        Long group1Id = group1.getId();
        Optional<Group> foundGroup = Optional.ofNullable(groupService.getOne(group1Id));

        // Then
        assertNotNull(foundGroup);
        assertEquals(group1Id, foundGroup.get().getId());
    }

    @Test
    public void shouldSaveGroup() {

        // Given
        Group group1 = new Group();
        Group group2 = new Group();
        group1.setName("Group 1");
        group2.setName("Group 2");

        // When
        groupService.save(group1);
        groupService.save(group2);
        Long group1Id = group1.getId();
        Long group2Id = group2.getId();
        Optional<Group> savedGroup1 = Optional.ofNullable(groupService.getOne(group1Id));
        Optional<Group> savedGroup2 = Optional.ofNullable(groupService.getOne(group2Id));

        // Then
        assertEquals("Group 1", savedGroup1.get().getName());
        assertEquals("Group 2", savedGroup2.get().getName());
    }

    @Test
    public void shouldUpdateGroup() {

        // Given
        Group group = new Group();

        // When
        groupService.save(group);
        group.setName("Group 1");
        groupService.update(group);
        Long groupId = group.getId();
        Group updatedGroup = groupService.getOne(groupId);

        // Then
        assertTrue(groupRepository.existsById(groupId));
        assertEquals("Group 1", updatedGroup.getName());
    }

    @Test
    public void shouldDeleteGroupSoftly() {

        // Given
        long currentNumberOfGroups = groupService.getAll().size();
        Group group1 = new Group();
        Group group2 = new Group();

        // When
        groupService.save(group1);
        groupService.save(group2);
        Long group1Id = group1.getId();
        groupService.delete(group1Id);
        String ex = "";
        try {
            Group removedGroup = groupService.getOne(group1Id);
        } catch(Exception e) {
            ex = e.getLocalizedMessage();
        }
        long availableGroups = groupService.getAll().size();

        // Then
        assertEquals("404 NOT_FOUND \"Service group not found\"", ex);
        assertEquals(currentNumberOfGroups + 1, availableGroups);
    }
}