package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import com.stc.assessment.systemdesign.enums.PermissionLevel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionDto extends STCAbstractDto {
    private Long id;
    private String userEmail;
    private PermissionLevel permissionLevel;
    private PermissionGroupDto permissionGroupDto;
}
