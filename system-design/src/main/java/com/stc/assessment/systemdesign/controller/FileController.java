package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.FileDownloadDto;
import com.stc.assessment.systemdesign.dto.FileDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.dto.MetaDataFilterDto;
import com.stc.assessment.systemdesign.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

@RestController
@RequiredArgsConstructor
public class FileController implements FileApi {

    private final FileService fileService;

    /**
     * Create file response entity.
     *
     * @param file         the file
     * @param userEmail    the user email
     * @param parentItemId the parent item id
     * @return the response entity
     */
    @Override
    public ResponseEntity<ItemDto> createFile(MultipartFile file, String userEmail, Long parentItemId) {
        ItemDto itemDto = fileService.createFile(file, userEmail, parentItemId);
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }

    /**
     * View meta data response entity.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the response entity
     */
    @Override
    public ResponseEntity<ItemDto> viewMetaData(MetaDataFilterDto metaDataFilterDto) {
        ItemDto itemDto = fileService.viewMetaData(metaDataFilterDto);
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }

    /**
     * Download file response entity.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the response entity
     */
    @Override
    public ResponseEntity<Resource> downloadFile(MetaDataFilterDto metaDataFilterDto) {
        FileDownloadDto fileDownloadDto = fileService.downloadFile(metaDataFilterDto);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(fileDownloadDto.getFileDto().getData()));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; " + fileDownloadDto.getFileName());
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileDownloadDto.getFileDto().getData().length)
                .body(resource);
    }
}
