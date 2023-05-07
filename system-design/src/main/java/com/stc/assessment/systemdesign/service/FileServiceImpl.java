package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dao.FileDao;
import com.stc.assessment.systemdesign.dto.*;
import com.stc.assessment.systemdesign.enums.ItemType;
import com.stc.assessment.systemdesign.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileDao fileDao;
    private final ItemService itemService;

    /**
     * Create file item dto.
     *
     * @param file         the file
     * @param userEmail    the user email
     * @param parentItemId the parent item id
     * @return the item dto
     */
    @Override
    public ItemDto createFile(MultipartFile file, String userEmail, Long parentItemId) {
        try {
            String fileName = StringUtils.getFilename(file.getOriginalFilename());
            byte[] fileData = file.getBytes();
            AddedItemDto addedItemDto = AddedItemDto.builder()
                    .name(fileName)
                    .userEmail(userEmail)
                    .parentItemId(parentItemId)
                    .build();
            ItemDto fileItemDto = itemService.createItem(addedItemDto, ItemType.FILE);

            FileDto fileDto = FileDto.builder()
                    .data(fileData)
                    .itemDto(fileItemDto)
                    .build();
            fileDao.create(fileDto);

            return fileItemDto;
        } catch (IOException e) {
            throw new InvalidDataException("Invalid file data");
        }
    }

    /**
     * View meta data item dto.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the item dto
     */
    @Override
    public ItemDto viewMetaData(MetaDataFilterDto metaDataFilterDto) {
        return itemService.findByNameAndUserEmail(metaDataFilterDto.getFileName(), metaDataFilterDto.getUserEmail());
    }

    /**
     * Download file data.
     *
     * @param metaDataFilterDto the meta data filter
     * @return the file dto
     */
    @Override
    public FileDownloadDto downloadFile(MetaDataFilterDto metaDataFilterDto) {
        ItemDto fileItemDto = viewMetaData(metaDataFilterDto);
        FileDto fileDto = fileDao.findByItemId(fileItemDto.getId());
        return FileDownloadDto.builder()
                .fileName(fileItemDto.getName())
                .fileDto(fileDto)
                .build();
    }
}
