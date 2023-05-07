package com.stc.assessment.systemdesign.mapper;

import com.stc.assessment.systemdesign.common.mapper.STCMapper;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMapper implements STCMapper<ItemEntity, ItemDto> {

    private final PermissionGroupMapper permissionGroupMapper;

    @Override
    public ItemDto mapToDto(ItemEntity entity) {
        ItemDto dto = new ItemDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setPermissionGroupDto(permissionGroupMapper.mapToDto(entity.getPermissionGroup()));
        if (entity.getParentItem() != null) {
            dto.setParentItem(mapToDto(entity.getParentItem()));
        }
        return dto;
    }

    @Override
    public ItemEntity mapToEntity(ItemDto dto) {
        ItemEntity entity = new ItemEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setPermissionGroup(permissionGroupMapper.mapToEntity(dto.getPermissionGroupDto()));
        if (dto.getParentItem() != null) {
            entity.setParentItem(mapToEntity(dto.getParentItem()));
        }
        return entity;
    }
}
