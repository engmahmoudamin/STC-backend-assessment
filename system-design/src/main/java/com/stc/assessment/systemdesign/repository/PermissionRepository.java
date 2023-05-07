package com.stc.assessment.systemdesign.repository;

import com.stc.assessment.systemdesign.entity.PermissionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends CrudRepository<PermissionEntity, Long> {

    @Query("SELECT p FROM PermissionEntity p WHERE p.userEmail = :userEmail AND p.permissionGroup.groupName = :groupName")
    Optional<PermissionEntity> findByUserEmailAndGroupName(@Param("userEmail") String userEmail, @Param("groupName") String groupName);
}
