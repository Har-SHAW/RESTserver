package com.zemoso.restaurant.mapper;

import com.zemoso.restaurant.dtos.ItemDto;
import com.zemoso.restaurant.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto fromItem(Item item);

    Item toItem(ItemDto itemDto);
}
