package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.mappers.CopyMapper;
import com.gunmProg.LibManagement.models.dtos.CopyDto;
import com.gunmProg.LibManagement.models.entities.Copy;
import com.gunmProg.LibManagement.repositories.CopyRepository;
import com.gunmProg.LibManagement.services.contract.CopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CopyServiceImpl implements CopyService {

    public static final String ENTITY_NAME= "copy";

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private CopyMapper copyMapper;

    @Override
    public CopyDto create(CopyDto copyDto) {
        Copy newCopy = copyMapper.convertToCopy(copyDto);
        copyRepository.save(newCopy);
        return copyMapper.convertToCopyDto(newCopy);
    }

    @Override
    public CopyDto getById(Long id) {
        Optional<Copy> optionalCopy = copyRepository.findById(id);
        if (optionalCopy.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return copyMapper.convertToCopyDto(optionalCopy.get());
    }

    @Override
    public void delete(CopyDto copyDto) {
        copyRepository.delete(copyMapper.convertToCopy(copyDto));

    }
}
