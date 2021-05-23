package com.zemoso.restaurant.service_implementations;

import com.zemoso.restaurant.dtos.ItemDto;
import com.zemoso.restaurant.entities.Item;
import com.zemoso.restaurant.mapper.ItemMapper;
import com.zemoso.restaurant.repositories.ItemsRepository;
import com.zemoso.restaurant.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImplementation implements ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemsRepository.findAll();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            itemDtos.add(ItemMapper.INSTANCE.fromItem(item));
        }
        return itemDtos;
    }

    @Override
    public ItemDto getItem(Long itemId) {
        var item = itemsRepository.getById(itemId);
        return ItemMapper.INSTANCE.fromItem(item);
    }

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        var item = ItemMapper.INSTANCE.toItem(itemDto);
        return ItemMapper.INSTANCE.fromItem(itemsRepository.save(item));
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto, Long itemId) {
        var item = itemsRepository.findById(itemId).orElseThrow();
        item.setItemName(itemDto.getItemName());
        item.setItemPrice(itemDto.getItemPrice());
        return ItemMapper.INSTANCE.fromItem(itemsRepository.save(item));
    }

    @Override
    public void deleteItem(Long itemId) {
        itemsRepository.deleteById(itemId);
    }

    @Override
    public void addBulk(List<ItemDto> itemDtos) {
        List<Item> items = new ArrayList<>();
        for (ItemDto itemDto : itemDtos){
            items.add(ItemMapper.INSTANCE.toItem(itemDto));
        }
        itemsRepository.saveAll(items);
    }
}
