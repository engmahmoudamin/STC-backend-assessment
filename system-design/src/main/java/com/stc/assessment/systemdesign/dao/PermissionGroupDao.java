package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCCrudDao;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

import java.util.List;

/**
 * The interface Permission group dao.
 */
public interface PermissionGroupDao extends STCCrudDao<PermissionGroupDto> {

    /**
     * Gets all group.
     *
     * @return the all group
     * @throws NoElementFoundException the no element found exception
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
