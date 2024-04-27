package com.artamonov.library.dto.mappers;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.models.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "publishingHouse", ignore = true)
    BookDto sourceToDto(BookEntity entity);
    @Mapping(target = "publishingHouse", ignore = true)
    BookEntity destinationToEntity(BookDto dto);
}
