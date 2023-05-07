package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.AddedItemDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.enums.ItemType;
import com.stc.assessment.systemdesign.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController implements ItemApi {

    private final ItemService itemService;

    /**
     * Create space response entity.
     *
     * @param addedItemDto the added item dto
     * @return the response entity
     */
    @Override
    public ResponseEntity<ItemDto> createSpace(AddedItemDto addedItemDto) {
        ItemDto itemDto = itemService.createItem(addedItemDto, ItemType.SPACE);
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }

    /**
     * Create folder response entity.
     *
     * @param addedItemDto the added item dto
     * @return the response entity
     */
    @Override
    public ResponseEntity<ItemDto> createFolder(AddedItemDto addedItemDto) {
        ItemDto itemDto = itemService.createItem(addedItemDto, ItemType.FOLDER);
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }
}
