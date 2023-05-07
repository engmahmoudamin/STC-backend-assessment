package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import com.stc.assessment.systemdesign.enums.PermissionLevel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddedPermissionDto extends STCAbstractDto {
    private String userEmail;
    private PermissionLevel permissionLevel;
    private String groupName;
}
