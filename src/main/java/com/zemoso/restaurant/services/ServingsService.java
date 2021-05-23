package com.zemoso.restaurant.services;

import com.zemoso.restaurant.dtos.ServingDto;
import com.zemoso.restaurant.dtos.ServingItemDto;
import com.zemoso.restaurant.dtos.ServingsWithItemsDto;

import java.util.List;

public interface ServingsService {
    List<ServingDto> getAllServings(String waiterId);
    ServingDto addServing(ServingsWithItemsDto servingDto, String waiterId);
    ServingDto updateServing(ServingDto servingDto, Long servingId);
    List<ServingItemDto> getServingItems(Long servingId);
}
