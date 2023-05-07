package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.AddedPermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import com.stc.assessment.systemdesign.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermissionController implements PermissionApi {

    private final PermissionService permissionService;

    /**
     * Create permission response entity.
     *
     * @param addedPermissionDto the added permission dto
     * @return the response entity
     */
    @Override
    public ResponseEntity<PermissionDto> createPermission(AddedPermissionDto addedPermissionDto) {
        PermissionDto permissionDto = permissionService.createPermission(addedPermissionDto);
        return new ResponseEntity<>(permissionDto, HttpStatus.OK);
    }

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     */
    @Override
    public ResponseEntity<List<PermissionDto>> getAllPermissions() {
        List<PermissionDto> allPermissions = permissionService.getAllPermissions();
        return new ResponseEntity<>(allPermissions, HttpStatus.OK);
    }
}
