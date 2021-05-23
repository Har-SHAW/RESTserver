package com.zemoso.restaurant.mapper;

import com.zemoso.restaurant.dtos.ServingItemDto;
import com.zemoso.restaurant.entities.ServingItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServingItemMapper {
    ServingItemMapper INSTANCE = Mappers.getMapper(ServingItemMapper.class);

    ServingItem toServingItems(ServingItemDto servingItemDto);

    ServingItemDto fromServingItems(ServingItem servingItem);
}
