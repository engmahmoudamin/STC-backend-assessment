package com.stc.assessment.systemdesign.dao;

import com.stc.assessment.systemdesign.common.dao.STCAbstractBaseDao;
import com.stc.assessment.systemdesign.dto.FileDto;
import com.stc.assessment.systemdesign.entity.FileEntity;
import com.stc.assessment.systemdesign.entity.ItemEntity;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import com.stc.assessment.systemdesign.mapper.FileMapper;
import com.stc.assessment.systemdesign.repository.FileRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FileDaoImpl extends STCAbstractBaseDao<FileEntity, FileDto, FileRepository, FileMapper>
        implements FileDao {
    public FileDaoImpl(FileMapper mapper, FileRepository repository) {
        super(mapper, repository);
    }

    /**
     * Find by item id file dto.
     *
     * @param itemId the item id
     * @return the file dto
     */
    @Override
    public FileDto findByItemId(Long itemId) throws NoElementFoundException {
        Optional<FileEntity> fileEntityOptional = repository.findByItemId(itemId);
        if (fileEntityOptional.isPresent()) {
            return mapper.mapToDto(fileEntityOptional.get());
        } else {
            throw new NoElementFoundException("No File is found with item id " + itemId);
        }
    }
}
