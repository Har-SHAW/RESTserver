package com.zemoso.restaurant.controlers;

import com.zemoso.restaurant.dtos.ServingDto;
import com.zemoso.restaurant.dtos.ServingItemDto;
import com.zemoso.restaurant.dtos.ServingsWithItemsDto;
import com.zemoso.restaurant.services.ServingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ServingsController {

    @Autowired
    ServingsService servingsService;

    @GetMapping("/servings")
    public ResponseEntity<List<ServingDto>> getAllServings(@RequestHeader("authorization") String waiterId){

        return ResponseEntity.ok().body(servingsService.getAllServings(waiterId));
    }

    @PostMapping("/servings")
    public ResponseEntity<ServingDto> addServing(@RequestBody ServingsWithItemsDto servings, @RequestHeader("authorization") String waiterId){
        return ResponseEntity.ok().body(servingsService.addServing(servings, waiterId));
    }

    @GetMapping("/servings/{servingId}/items")
    public ResponseEntity<List<ServingItemDto>> getItemsOfServing(@PathVariable("servingId") Long servingId){
        return ResponseEntity.ok().body(servingsService.getServingItems(servingId));
    }
}
