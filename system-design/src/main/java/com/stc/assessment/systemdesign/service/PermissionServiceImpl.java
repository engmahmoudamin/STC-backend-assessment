package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dao.PermissionDao;
import com.stc.assessment.systemdesign.dto.AddedPermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionDao permissionDao;
    private final PermissionGroupService permissionGroupService;

    /**
     * Create permission dto.
     *
     * @param addedPermissionDto the added permission dto
     * @return the permission dto
     */
    @Transactional
    @Override
    public PermissionDto createPermission(AddedPermissionDto addedPermissionDto) {
        PermissionGroupDto permissionGroupDto = permissionGroupService.findByName(addedPermissionDto.getGroupName());
        PermissionDto newPermissionDto = PermissionDto.builder()
                .userEmail(addedPermissionDto.getUserEmail())
                .permissionGroupDto(permissionGroupDto)
                .permissionLevel(addedPermissionDto.getPermissionLevel())
                .build();

        return permissionDao.create(newPermissionDto);
    }

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     */
    @Override
    public List<PermissionDto> getAllPermissions() {
        return permissionDao.getAllPermissions();
    }

    /**
     * Find by user email and group name permission dto.
     *
     * @param userEmail the user email
     * @param groupName the group name
     * @return the permission dto
     * @throws NoElementFoundException the no element found exception
     */
    @Override
    public PermissionDto findByUserEmailAndGroupName(String userEmail, String groupName) throws NoElementFoundException {
        return permissionDao.findByUserEmailAndGroupName(userEmail, groupName);
    }


}
