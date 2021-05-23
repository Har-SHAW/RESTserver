package com.zemoso.restaurant.controlers;

import com.zemoso.restaurant.dtos.ItemDto;
import com.zemoso.restaurant.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok().body(itemsService.getAllItems());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemDto> getItem(@PathVariable("itemId") Long itemId){
        return ResponseEntity.ok().body(itemsService.getItem(itemId));
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getCourse());
        return ResponseEntity.ok().body(itemsService.addItem(itemDto));
    }

    @PostMapping("/items/bulk")
    public ResponseEntity<String> addItem(@RequestBody List<ItemDto> itemDtos){
        itemsService.addBulk(itemDtos);
        return ResponseEntity.ok().body("success");
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("itemId") Long itemId, @RequestBody ItemDto itemDto){
        return ResponseEntity.ok().body(itemsService.updateItem(itemDto, itemId));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Long itemId){
        itemsService.deleteItem(itemId);
        return ResponseEntity.ok().body("Success");
    }
}
