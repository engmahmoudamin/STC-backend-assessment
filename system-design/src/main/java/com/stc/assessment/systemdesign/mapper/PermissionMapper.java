package com.stc.assessment.systemdesign.mapper;

import com.stc.assessment.systemdesign.common.mapper.STCMapper;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.entity.PermissionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionMapper implements STCMapper<PermissionEntity, PermissionDto> {

    private final PermissionGroupMapper permissionGroupMapper;

    @Override
    public PermissionDto mapToDto(PermissionEntity entity) {
        PermissionDto dto = new PermissionDto();
        dto.setId(entity.getId());
        dto.setUserEmail(entity.getUserEmail());
        dto.setPermissionLevel(entity.getPermissionLevel());
        dto.setPermissionGroupDto(permissionGroupMapper.mapToDto(entity.getPermissionGroup()));
        return dto;
    }

    @Override
    public PermissionEntity mapToEntity(PermissionDto dto) {
        PermissionEntity entity = new PermissionEntity();
        entity.setId(dto.getId());
        entity.setUserEmail(dto.getUserEmail());
        entity.setPermissionLevel(dto.getPermissionLevel());
        entity.setPermissionGroup(permissionGroupMapper.mapToEntity(dto.getPermissionGroupDto()));
        return entity;
    }
}
