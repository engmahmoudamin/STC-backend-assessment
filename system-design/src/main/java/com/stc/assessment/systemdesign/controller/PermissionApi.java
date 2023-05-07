package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.dto.AddedPermissionDto;
import com.stc.assessment.systemdesign.dto.PermissionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The interface Permission api.
 */
@RequestMapping("/permissions")
public interface PermissionApi {

    /**
     * Create permission response entity.
     *
     * @param addedPermissionDto the added permission dto
     * @return the response entity
     */
    @PostMapping
    ResponseEntity<PermissionDto> createPermission(@RequestBody AddedPermissionDto addedPermissionDto);

    /**
     * Gets all permissions.
     *
     * @return the all permissions
     */
    @GetMapping
    ResponseEntity<List<PermissionDto>> getAllPermissions();
}
