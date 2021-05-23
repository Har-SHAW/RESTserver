package com.zemoso.restaurant.service_implementations;

import com.zemoso.restaurant.dtos.ServingDto;
import com.zemoso.restaurant.dtos.ServingItemDto;
import com.zemoso.restaurant.dtos.ServingsWithItemsDto;
import com.zemoso.restaurant.entities.Serving;
import com.zemoso.restaurant.entities.ServingItem;
import com.zemoso.restaurant.mapper.ServingItemMapper;
import com.zemoso.restaurant.mapper.ServingMapper;
import com.zemoso.restaurant.repositories.ItemsRepository;
import com.zemoso.restaurant.repositories.ServingsRepository;
import com.zemoso.restaurant.services.ServingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServingsServiceImplementation implements ServingsService {

    @Autowired
    ServingsRepository servingsRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public List<ServingDto> getAllServings(String waiterId) {
        List<Serving> servings = servingsRepository.findAllByWaiterIdOrderByIdDesc(waiterId);
        List<ServingDto> servingDtos = new ArrayList<>();
        for (Serving serving : servings){
            servingDtos.add(ServingMapper.INSTANCE.fromServing(serving));
        }
        return servingDtos;
    }

    @Override
    public ServingDto addServing(ServingsWithItemsDto servingDto, String waiterId) {
        var serving = ServingMapper.INSTANCE.toServing(servingDto);
        var totalItems = 0;
        var totalAmount = 0.0;
        serving.setServingItems(new ArrayList<>());

        for (ServingItemDto servingItemDto : servingDto.getItems()){
            var item = itemsRepository.getById(servingItemDto.getItem().getItemId());
            totalAmount += servingItemDto.getServings() * item.getItemPrice();
            var servingItem = new ServingItem();
            servingItem.setServings(servingItemDto.getServings());
            servingItem.setItem(item);
            servingItem.setServing(serving);
            serving.addServingItem(servingItem);
            totalItems += 1;
        }

        serving.setTotalPrice(totalAmount);
        serving.setTotalItems(totalItems);
        serving.setWaiterId(waiterId);

        return ServingMapper.INSTANCE.fromServing(servingsRepository.save(serving));
    }

    @Override
    public ServingDto updateServing(ServingDto servingDto, Long servingId) {
        return null;
    }

    @Override
    public List<ServingItemDto> getServingItems(Long servingId) {
        List<ServingItem> servingItems = servingsRepository.getById(servingId).getServingItems();
        List<ServingItemDto> servingItemDto = new ArrayList<>();
        for (ServingItem servingItem : servingItems){
            servingItemDto.add(ServingItemMapper.INSTANCE.fromServingItems(servingItem));
        }
        return servingItemDto;
    }
}
