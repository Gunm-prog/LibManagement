package com.gunmProg.LibManagement.mappers;

import com.gunmProg.LibManagement.models.dtos.CopyDto;
import com.gunmProg.LibManagement.models.entities.Copy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CopyMapper {

    Copy convertToCopy(CopyDto copyDto);

    CopyDto convertToCopyDto(Copy copy);
}
