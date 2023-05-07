package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dto.FileDownloadDto;
import com.stc.assessment.systemdesign.dto.FileDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.dto.MetaDataFilterDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * The interface File service.
 */
public interface FileService {
    /**
     * Create file item dto.
     *
     * @param file         the file
     * @param userEmail    the user email
     * @param parentItemId the parent item id
     * @return the item dto
     */
    ItemDto createFile(MultipartFile file, String userEmail, Long parentItemId);


    /**
     * View meta data item dto.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the item dto
     */
    ItemDto viewMetaData(MetaDataFilterDto metaDataFilterDto);


    /**
     * Download file data.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the file dto
     */
    FileDownloadDto downloadFile(MetaDataFilterDto metaDataFilterDto);
}
