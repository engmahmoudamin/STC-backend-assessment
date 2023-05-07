package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCAbstractBaseDao;
import com.stc.assessment.systemdesign.dto.ItemDto;
import com.stc.assessment.systemdesign.entity.ItemEntity;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import com.stc.assessment.systemdesign.mapper.ItemMapper;
import com.stc.assessment.systemdesign.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ItemDaoImpl extends STCAbstractBaseDao<ItemEntity, ItemDto, ItemRepository, ItemMapper>
        implements ItemDao {
    public ItemDaoImpl(ItemMapper mapper, ItemRepository repository) {
        super(mapper, repository);
    }

    /**
     * @param name
     * @return
     * @throws NoElementFoundException
     */
    @Override
    public ItemDto findByName(String name) throws NoElementFoundException {
        Optional<ItemEntity> itemEntityOptional = repository.findByName(name);
        if (itemEntityOptional.isPresent()) {
            return mapper.mapToDto(itemEntityOptional.get());
        } else {
            throw new NoElementFoundException("No Item is found with name " + name);
        }
    }
}
