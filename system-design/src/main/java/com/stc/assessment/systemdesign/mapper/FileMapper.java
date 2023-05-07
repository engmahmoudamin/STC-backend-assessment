package com.stc.assessment.systemdesign.mapper;

import com.stc.assessment.systemdesign.common.mapper.STCMapper;
import com.stc.assessment.systemdesign.dto.FileDto;
import com.stc.assessment.systemdesign.entity.FileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileMapper implements STCMapper<FileEntity, FileDto> {

    private final ItemMapper itemMapper;

    @Override
    public FileDto mapToDto(FileEntity entity) {
        FileDto dto = new FileDto();
        dto.setId(entity.getId());
        dto.setData(entity.getData());
        dto.setItemDto(itemMapper.mapToDto(entity.getItem()));
        return dto;
    }

    @Override
    public FileEntity mapToEntity(FileDto dto) {
        FileEntity entity = new FileEntity();
        entity.setId(dto.getId());
        entity.setData(dto.getData());
        entity.setItem(itemMapper.mapToEntity(dto.getItemDto()));
        return entity;
    }
}
