package com.zemoso.restaurant.services;

import com.zemoso.restaurant.dtos.ItemDto;

import java.util.List;

public interface ItemsService {
    List<ItemDto> getAllItems();
    ItemDto getItem(Long itemId);
    ItemDto addItem(ItemDto itemDto);
    ItemDto updateItem(ItemDto itemDto, Long itemId);
    void deleteItem(Long itemId);
    void addBulk(List<ItemDto> itemDtos);
}
