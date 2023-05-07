package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

import java.util.List;

/**
 * The interface Permission group service.
 */
public interface PermissionGroupService {
    /**
     * Create permission group dto.
     *
     * @param permissionGroupDto the permission group dto
     * @return the permission group dto
     */
    PermissionGroupDto createPermissionGroup(PermissionGroupDto permissionGroupDto);

    /**
     * Gets all group.
     *
     * @return the all group
     */
    List<PermissionGroupDto> getAllGroups() throws NoElementFoundException;

    /**
     * Find by name permission group dto.
     *
     * @param groupName the group name
     * @return the permission group dto
     * @throws NoElementFoundException the no element found exception
     */
    PermissionGroupDto findByName(String groupName) throws NoElementFoundException;
}
