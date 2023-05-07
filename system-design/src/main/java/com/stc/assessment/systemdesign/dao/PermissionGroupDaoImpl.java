package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCAbstractBaseDao;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.entity.PermissionGroupEntity;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import com.stc.assessment.systemdesign.mapper.PermissionGroupMapper;
import com.stc.assessment.systemdesign.repository.PermissionGroupRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PermissionGroupDaoImpl extends STCAbstractBaseDao<PermissionGroupEntity, PermissionGroupDto, PermissionGroupRepository, PermissionGroupMapper>
        implements PermissionGroupDao {

    public PermissionGroupDaoImpl(PermissionGroupMapper mapper, PermissionGroupRepository repository) {
        super(mapper, repository);
    }

    /**
     * Gets all group.
     *
     * @return the all group
     */
    @Override
    public List<PermissionGroupDto> getAllGroups() throws NoElementFoundException {
        List<PermissionGroupEntity> permissionGroupEntities = (List<PermissionGroupEntity>) repository.findAll();
        if (!permissionGroupEntities.isEmpty()) {
            return permissionGroupEntities.stream().map(mapper::mapToDto).collect(Collectors.toList());
        } else {
            throw new NoElementFoundException("No Permission Groups are found");
        }
    }

    /**
     * Find by name permission group dto.
     *
     * @param groupName the group name
     * @return the permission group dto
     */
    @Override
    public PermissionGroupDto findByName(String groupName) throws NoElementFoundException {
        Optional<PermissionGroupEntity> permissionGroupEntityOptional = repository.findByGroupName(groupName);
        if (permissionGroupEntityOptional.isPresent()) {
            return mapper.mapToDto(permissionGroupEntityOptional.get());
        } else {
            throw new NoElementFoundException("No Permission Group is found by name " + groupName);
        }
    }
}
