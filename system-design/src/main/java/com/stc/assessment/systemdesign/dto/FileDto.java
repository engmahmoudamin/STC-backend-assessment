package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDto extends STCAbstractDto {
    private Long id;
    private byte[] data;
    private Long itemId;
    private ItemDto itemDto;
}
