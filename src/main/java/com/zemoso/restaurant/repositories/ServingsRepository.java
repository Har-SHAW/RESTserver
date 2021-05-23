package com.zemoso.restaurant.repositories;

import com.zemoso.restaurant.entities.Serving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServingsRepository extends JpaRepository<Serving, Long> {
    List<Serving> findAllByWaiterIdOrderByIdDesc(String waiterId);
}
