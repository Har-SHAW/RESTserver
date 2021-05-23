package com.zemoso.restaurant.mapper;

import com.zemoso.restaurant.dtos.ServingDto;
import com.zemoso.restaurant.dtos.ServingsWithItemsDto;
import com.zemoso.restaurant.entities.Serving;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServingMapper {
    ServingMapper INSTANCE = Mappers.getMapper(ServingMapper.class);

    ServingDto fromServing(Serving serving);


    Serving toServing(ServingsWithItemsDto servingDto);
}
