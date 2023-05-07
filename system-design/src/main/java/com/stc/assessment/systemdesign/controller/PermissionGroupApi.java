package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The interface Permission group api.
 */
@RequestMapping("/groups")
public interface PermissionGroupApi {

    /**
     * Create permission group response entity.
     *
     * @param permissionGroupDto the permission group dto
     * @return the response entity
     */
    @PostMapping
    ResponseEntity<PermissionGroupDto> createPermissionGroup(@RequestBody PermissionGroupDto permissionGroupDto);

    /**
     * Gets all group.
     *
     * @return the all group
     */
    @GetMapping
    ResponseEntity<List<PermissionGroupDto>> getAllGroups();
}
