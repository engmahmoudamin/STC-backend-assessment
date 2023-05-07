package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCCrudDao;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

import java.util.List;

/**
 * The interface Permission dao.
 */
public interface PermissionDao  extends STCCrudDao<PermissionDto> {

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     * @throws NoElementFoundException the no element found exception
     */
    List<PermissionDto> getAllPermissions() throws NoElementFoundException;

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
