package com.stc.assessment.systemdesign.mapper;

import com.stc.assessment.systemdesign.common.mapper.STCMapper;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.entity.PermissionGroupEntity;
import org.springframework.stereotype.Component;

@Component
public class PermissionGroupMapper implements STCMapper<PermissionGroupEntity, PermissionGroupDto> {

    @Override
    public PermissionGroupDto mapToDto(PermissionGroupEntity entity) {
        PermissionGroupDto dto = new PermissionGroupDto();
        dto.setId(entity.getId());
        dto.setGroupName(entity.getGroupName());
        return dto;
    }

    @Override
    public PermissionGroupEntity mapToEntity(PermissionGroupDto dto) {
        PermissionGroupEntity entity = new PermissionGroupEntity();
        entity.setId(dto.getId());
        entity.setGroupName(dto.getGroupName());
        return entity;
    }
}
