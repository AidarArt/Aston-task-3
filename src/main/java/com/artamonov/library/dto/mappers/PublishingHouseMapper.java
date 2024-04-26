package com.artamonov.library.dto.mappers;

import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.models.PublishingHouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublishingHouseMapper {

    PublishingHouseMapper INSTANCE = Mappers.getMapper(PublishingHouseMapper.class);

    PublishingHouseDto sourceToDto(PublishingHouseEntity entity);
    PublishingHouseEntity destinationToEntity(PublishingHouseDto dto);
}
