package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCAbstractBaseDao;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.entity.PermissionEntity;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import com.stc.assessment.systemdesign.mapper.PermissionMapper;
import com.stc.assessment.systemdesign.repository.PermissionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PermissionDaoImpl extends STCAbstractBaseDao<PermissionEntity, PermissionDto, PermissionRepository, PermissionMapper>
        implements PermissionDao {

    public PermissionDaoImpl(PermissionMapper mapper, PermissionRepository repository) {
        super(mapper, repository);
    }

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     */
    @Override
    public List<PermissionDto> getAllPermissions() throws NoElementFoundException {
        List<PermissionEntity> permissionEntities = (List<PermissionEntity>) repository.findAll();
        if (!permissionEntities.isEmpty()) {
            return permissionEntities.stream().map(mapper::mapToDto).collect(Collectors.toList());
        } else {
            throw new NoElementFoundException("No Permissions are found");
        }
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
        Optional<PermissionEntity> permissionEntityOptional = repository.findByUserEmailAndGroupName(userEmail, groupName);
        if (permissionEntityOptional.isPresent()) {
            return mapper.mapToDto(permissionEntityOptional.get());
        } else {
            throw new NoElementFoundException("No Permission is found with user Email " +
                    userEmail + " and group Name " + groupName);
        }
    }
}
