package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.PermissionGroupDto;
import com.stc.assessment.systemdesign.service.PermissionGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Permission group controller.
 */
@RestController
@RequiredArgsConstructor
public class PermissionGroupController implements PermissionGroupApi {

    private final PermissionGroupService permissionGroupService;

    @Override
    public ResponseEntity<PermissionGroupDto> createPermissionGroup(PermissionGroupDto permissionGroupDto) {
        PermissionGroupDto createdPermissionGroupDto = permissionGroupService.createPermissionGroup(permissionGroupDto);
        return new ResponseEntity<>(createdPermissionGroupDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PermissionGroupDto>> getAllGroups() {
        List<PermissionGroupDto> allGroups = permissionGroupService.getAllGroups();
        return new ResponseEntity<>(allGroups, HttpStatus.OK);
    }
}
