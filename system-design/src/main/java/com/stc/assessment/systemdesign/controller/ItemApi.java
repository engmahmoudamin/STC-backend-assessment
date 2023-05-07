package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.AddedItemDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The interface Item api.
 */
@RequestMapping("/items")
public interface ItemApi {

    /**
     * Create space response entity.
     *
     * @param addedItemDto the added item dto
     * @return the response entity
     */
    @PostMapping("/space")
    ResponseEntity<ItemDto> createSpace(@RequestBody AddedItemDto addedItemDto);

    /**
     * Create folder response entity.
     *
     * @param addedItemDto the added item dto
     * @return the response entity
     */
    @PostMapping("/folder")
    ResponseEntity<ItemDto> createFolder(@RequestBody AddedItemDto addedItemDto);
}
