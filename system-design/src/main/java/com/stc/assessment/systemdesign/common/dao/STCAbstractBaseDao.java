package com.stc.assessment.systemdesign.common.dao;

import com.stc.assessment.systemdesign.common.dto.STCAbstractDto;
import com.stc.assessment.systemdesign.common.entity.STCAbstractEntity;
import com.stc.assessment.systemdesign.common.mapper.STCMapper;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

public abstract class STCAbstractBaseDao<E extends STCAbstractEntity, D extends STCAbstractDto, R extends CrudRepository, M extends STCMapper<E, D>>
        implements STCCrudDao<D> {


    protected M mapper;
    protected R repository;

    public STCAbstractBaseDao(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public D create(D dto) {
        D createdDto = null;
        E transientEntity = mapper.mapToEntity(dto);
        if (transientEntity != null) {
            E entity = (E) repository.save(transientEntity);
            if (entity != null)
                createdDto = mapper.mapToDto(entity);
        }
        return createdDto;
    }

    public D retrieve(Object id) {
        if (id != null) {
            Optional<E> result = repository.findById(id);
            if (result.isPresent())
                return mapper.mapToDto(result.get());
        }
        return null;
    }

    public D update(D dto) {
        D updatedDto = null;
        E entity = mapper.mapToEntity(dto);
        if (entity != null) {
            if (repository.existsById(entity.loadId())) {
                entity = (E) repository.save(entity);
                updatedDto = mapper.mapToDto(entity);
            }
        }
        return updatedDto;
    }

    public Boolean delete(D dto) {
        boolean deleted = false;
        if (dto != null) {
            E entity = mapper.mapToEntity(dto);
            if (repository.existsById(entity.loadId())) {
                repository.delete(entity);
                deleted = true;
            }
        }
        return deleted;
    }
}
