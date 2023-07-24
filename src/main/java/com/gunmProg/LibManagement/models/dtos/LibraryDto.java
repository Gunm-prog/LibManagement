package com.gunmProg.LibManagement.models.dtos;

import com.gunmProg.LibManagement.models.entities.Copy;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class LibraryDto {

    private Long id;

    private String name;

    private AddressDto address;

    private Set<CopyDto> copies;
}
