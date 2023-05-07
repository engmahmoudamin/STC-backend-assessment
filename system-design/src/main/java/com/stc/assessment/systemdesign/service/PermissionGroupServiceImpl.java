package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dao.PermissionGroupDao;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.exception.ElementAlreadyExistsException;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Permission group service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionGroupServiceImpl implements PermissionGroupService {

    private final PermissionGroupDao permissionGroupDao;

    /**
     * Create permission group dto.
     *
     * @param permissionGroupDto the permission group dto
     * @return the permission group dto
     */
    @Transactional
    @Override
    public PermissionGroupDto createPermissionGroup(PermissionGroupDto permissionGroupDto) throws ElementAlreadyExistsException {
        try {
            PermissionGroupDto existedPermissionGroup = permissionGroupDao.findByName(permissionGroupDto.getGroupName());
            throw new ElementAlreadyExistsException("Permission Group with name " +
                    existedPermissionGroup.getGroupName() + " is already exists");
        } catch (NoElementFoundException ex) {
            return permissionGroupDao.create(permissionGroupDto);
        }
    }

    /**
     * Gets all group.
     *
     * @return the all group
     */
    @Override
    public List<PermissionGroupDto> getAllGroups() throws NoElementFoundException {
        return permissionGroupDao.getAllGroups();
    }

    /**
     * Find by name permission group dto.
     *
     * @param groupName the group name
     * @return the permission group dto
     * @throws NoElementFoundException the no element found exception
     */
    @Override
    public PermissionGroupDto findByName(String groupName) throws NoElementFoundException {
        return permissionGroupDao.findByName(groupName);
    }
}
