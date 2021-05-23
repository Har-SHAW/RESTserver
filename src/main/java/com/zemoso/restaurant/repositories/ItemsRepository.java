package com.zemoso.restaurant.repositories;

import com.zemoso.restaurant.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long> {
}
