package com.stc.assessment.systemdesign.repository;

import com.stc.assessment.systemdesign.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends CrudRepository<FileEntity, Long> {
    Optional<FileEntity> findByItemId(Long itemId);
}
