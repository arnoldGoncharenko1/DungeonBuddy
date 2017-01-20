package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

/**
 * Created by Arnold on 12/6/2016.
 */

public class item extends SugarRecord{
    int itemId;
    String name;
    String cost;
    int weight;
    String description;
    String rarity;

    public item() {
        name = "";
        cost = "";
        weight = 0;
        description = "";
        rarity = "";
    }

    public item(int ItemId, String name, String cost, int weight, String description, String rarity) {
        this.itemId = itemId;
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.description = description;
        this.rarity = rarity;
    }
}
