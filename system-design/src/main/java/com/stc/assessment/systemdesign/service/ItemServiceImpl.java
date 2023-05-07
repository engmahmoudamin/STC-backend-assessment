package com.stc.assessment.systemdesign.service;

import com.stc.assessment.systemdesign.dao.ItemDao;
import com.stc.assessment.systemdesign.dto.AddedItemDto;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.enums.ItemType;
import com.stc.assessment.systemdesign.enums.PermissionLevel;
import com.stc.assessment.systemdesign.exception.InvalidDataException;
import com.stc.assessment.systemdesign.exception.InvalidAccessPermissionException;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The type Item service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDao;
    private final PermissionService permissionService;
    private final PermissionGroupService permissionGroupService;

    /**
     * Create item item dto.
     *
     * @param addedItemDto the added item dto
     * @param itemType     the item type
     * @return the item dto
     */
    @Override
    public ItemDto createItem(AddedItemDto addedItemDto, ItemType itemType) {
        ItemDto dto;
        if(itemType.equals(ItemType.SPACE)){
            dto = buildSpaceItem(addedItemDto);
        } else {
            dto = buildFolderOrFileItem(addedItemDto, itemType);
        }
        return itemDao.create(dto);
    }

    private ItemDto buildSpaceItem(AddedItemDto addedItemDto) {
        if (addedItemDto.getGroupName() == null) {
            throw new InvalidDataException("Group Name is required");
        }

        PermissionGroupDto permissionGroupDto = permissionGroupService.findByName(addedItemDto.getGroupName());
        return ItemDto.builder()
                .permissionGroupDto(permissionGroupDto)
                .type(ItemType.SPACE)
                .name(addedItemDto.getName())
                .build();
    }

    private ItemDto buildFolderOrFileItem(AddedItemDto addedItemDto, ItemType itemType) {
        if (addedItemDto.getUserEmail() == null) {
            throw new InvalidDataException("User Email is required");
        }

        if (addedItemDto.getParentItemId() == null || addedItemDto.getParentItemId() == 0) {
            throw new InvalidDataException("Parent Item Id is required");
        }

        ItemDto parentItemDto = findById(addedItemDto.getParentItemId());
        PermissionDto permissionDto = permissionService.findByUserEmailAndGroupName(addedItemDto.getUserEmail(),
                parentItemDto.getPermissionGroupDto().getGroupName());

        if (permissionDto.getPermissionLevel().equals(PermissionLevel.READ_ACCESS)) {
            throw new InvalidAccessPermissionException("User with email " + addedItemDto.getUserEmail() +
                    " has only VIEW access and must have EDIT access");
        }

        return ItemDto.builder()
                .permissionGroupDto(permissionDto.getPermissionGroupDto())
                .parentItem(parentItemDto)
                .type(itemType)
                .name(addedItemDto.getName())
                .build();
    }

    /**
     * Find by id permission dto.
     *
     * @param id the id
     * @return the permission dto
     * @throws NoElementFoundException the no element found exception
     */
    @Override
    public ItemDto findById(Long id) throws NoElementFoundException {
        ItemDto itemDto = itemDao.retrieve(id);
        if (itemDto != null) {
            return itemDto;
        } else {
            throw new NoElementFoundException("No Item is found by id " + id);
        }
    }

    /**
     * Find by name and user email item dto.
     *
     * @param name      the name
     * @param userEmail the user email
     * @return the item dto
     * @throws NoElementFoundException the no element found exception
     */
    @Override
    public ItemDto findByNameAndUserEmail(String name, String userEmail) throws NoElementFoundException {
        if (name == null) {
            throw new InvalidDataException("Name is required");
        }

        if (userEmail == null) {
            throw new InvalidDataException("User Email is required");
        }

        ItemDto itemDto = itemDao.findByName(name);
        PermissionDto permissionDto = permissionService.findByUserEmailAndGroupName(userEmail,
                itemDto.getPermissionGroupDto().getGroupName());

        if (permissionDto.getPermissionLevel().equals(PermissionLevel.READ_ACCESS)) {
            throw new InvalidAccessPermissionException("User with email " + userEmail +
                    " has only VIEW access and must have EDIT access");
        }

        return itemDto;
    }
}
