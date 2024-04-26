package com.artamonov.library.dto.mappers;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.models.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto sourceToDto(AuthorEntity entity);
    AuthorEntity destinationToEntity(AuthorDto dto);

}
