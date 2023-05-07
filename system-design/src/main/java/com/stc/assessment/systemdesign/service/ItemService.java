package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dto.AddedItemDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.enums.ItemType;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;

/**
 * The interface Item service.
 */
public interface ItemService {

    /**
     * Create item item dto.
     *
     * @param addedItemDto the added item dto
     * @param itemType     the item type
     * @return the item dto
     */
    ItemDto createItem(AddedItemDto addedItemDto, ItemType itemType);

    /**
     * Find by id item dto.
     *
     * @param id the id
     * @return the item dto
     * @throws NoElementFoundException the no element found exception
     */
    ItemDto findById(Long id) throws NoElementFoundException;


    /**
     * Find by name and user email item dto.
     *
     * @param name      the name
     * @param userEmail the user email
     * @return the item dto
     * @throws NoElementFoundException the no element found exception
     */
    ItemDto findByNameAndUserEmail(String name, String userEmail) throws NoElementFoundException;
}
