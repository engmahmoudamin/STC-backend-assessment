package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCCrudDao;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

public interface ItemDao  extends STCCrudDao<ItemDto> {
    ItemDto findByName(String name) throws NoElementFoundException;
}
