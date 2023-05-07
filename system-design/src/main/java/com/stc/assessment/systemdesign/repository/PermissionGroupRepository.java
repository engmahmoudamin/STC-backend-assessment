package com.stc.assessment.systemdesign.repository;

import com.stc.assessment.systemdesign.entity.PermissionGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionGroupRepository extends CrudRepository<PermissionGroupEntity, Long> {
    Optional<PermissionGroupEntity> findByGroupName(String groupName);
}
