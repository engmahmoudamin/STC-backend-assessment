package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCCrudDao;
import com.stc.assessment.systemdesign.dto.FileDto;

/**
 * The interface File dao.
 */
public interface FileDao extends STCCrudDao<FileDto> {
    /**
     * Find by item id file dto.
     *
     * @param itemId the item id
     * @return the file dto
     */
    FileDto findByItemId(Long itemId);
}
