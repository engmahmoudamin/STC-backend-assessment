package com.stc.assessment.systemdesign.common.mapper;


import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import com.stc.assessment.systemdesign.common.entity.STCAbstractEntity;

public interface STCMapper<E extends STCAbstractEntity, D extends STCAbstractDto> {

    D mapToDto(E entity);

    E mapToEntity(D dto);
}
