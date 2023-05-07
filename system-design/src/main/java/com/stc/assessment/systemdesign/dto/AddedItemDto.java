package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddedItemDto extends STCAbstractDto {
    private String name;
    private String groupName;
    private String userEmail;
    private Long parentItemId;
}
