package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.CopyDto;

public interface CopyService {

    CopyDto create(CopyDto copyDto);

    CopyDto getById(Long id) throws NotFoundException;

    void delete(CopyDto copyDto);
}
