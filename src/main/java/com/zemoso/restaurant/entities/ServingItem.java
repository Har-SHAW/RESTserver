package com.zemoso.restaurant.entities;

import javax.persistence.*;

@Entity
public class ServingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servingItemsId;

    @ManyToOne
    @JoinColumn(name = "id")
    private Serving serving;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int servings;

    public Long getServingItemsId() {
        return servingItemsId;
    }

    public void setServingItemsId(Long servingItemsId) {
        this.servingItemsId = servingItemsId;
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }
}
