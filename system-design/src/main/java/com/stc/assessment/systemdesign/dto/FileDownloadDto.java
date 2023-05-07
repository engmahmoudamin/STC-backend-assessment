package com.stc.assessment.systemdesign.dto;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import lombok.*;

import java.io.ByteArrayOutputStream;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDownloadDto extends STCAbstractDto {
    private FileDto fileDto;
    private String fileName;
}
