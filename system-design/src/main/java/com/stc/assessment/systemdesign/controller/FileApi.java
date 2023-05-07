package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.dto.MetaDataFilterDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * The interface File api.
 */
@RequestMapping("/files")
public interface FileApi {

    /**
     * Create file response entity.
     *
     * @param file         the file
     * @param userEmail    the user email
     * @param parentItemId the parent item id
     * @return the response entity
     */
    @PostMapping
    ResponseEntity<ItemDto> createFile(@RequestParam("file") MultipartFile file,
                                       @RequestParam("userEmail") String userEmail,
                                       @RequestParam("parentItemId") Long parentItemId);


    /**
     * View meta data response entity.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the response entity
     */
    @PostMapping("/metadata")
    ResponseEntity<ItemDto> viewMetaData(@RequestBody MetaDataFilterDto metaDataFilterDto);

    /**
     * Download file response entity.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the response entity
     */
    @PostMapping("/download")
    ResponseEntity<Resource> downloadFile(@RequestBody MetaDataFilterDto metaDataFilterDto);
}
