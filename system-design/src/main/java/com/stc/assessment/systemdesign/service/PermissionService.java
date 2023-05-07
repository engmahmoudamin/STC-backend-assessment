package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dto.AddedPermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

import java.util.List;

/**
 * The interface Permission service.
 */
public interface PermissionService {
    /**
     * Create permission dto.
     *
     * @param addedPermissionDto the added permission dto
     * @return the permission dto
     */
    PermissionDto createPermission(AddedPermissionDto addedPermissionDto);

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     */
    List<PermissionDto> getAllPermissions();


    /**
     * Find by user email and group name permission dto.
     *
     * @param userEmail the user email
     * @param groupName the group name
     * @return the permission dto
     * @throws NoElementFoundException the no element found exception
     */
    PermissionDto findByUserEmailAndGroupName(String userEmail, String groupName) throws NoElementFoundException;
}
