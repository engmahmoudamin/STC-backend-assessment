package com.stc.assessment.systemdesign.common.dao;


import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;

public interface STCCrudDao<D extends STCAbstractDto> {
    D create(D dto);
    D retrieve(Object id);
    D update(D dto);
    Boolean delete(D dto);
}
