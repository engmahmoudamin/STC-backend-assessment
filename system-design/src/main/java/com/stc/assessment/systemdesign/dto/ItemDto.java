package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import com.stc.assessment.systemdesign.enums.ItemType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto extends STCAbstractDto {
    private Long id;
    private ItemType type;
    private String name;
    private ItemDto parentItem;
    private PermissionGroupDto permissionGroupDto;
}
