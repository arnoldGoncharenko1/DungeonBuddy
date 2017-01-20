package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Arnold on 12/6/2016.
 */

public class armor extends SugarRecord {
    int AC;
    String name;
    String cost;
    int weight;
    String description;
    String rarity;
    int equipped;

    public armor() {
        name = "";
        cost = "";
        weight = 0;
        description = "";
        rarity = "";
        AC = 0;
        equipped = 0;
    }

    public armor(int AC, String armorName, String armorCost, int armorWeight, String armorDescription, String armorRarity, int equipped) {
        name = armorName;
        cost = armorCost;
        weight = armorWeight;
        description = armorDescription;
        rarity = armorRarity;
        this.AC = AC;
        this.equipped = equipped;
    }
}
