package com.stc.assessment.systemdesign.repository;

import com.stc.assessment.systemdesign.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository  extends CrudRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByName(String name);
}
