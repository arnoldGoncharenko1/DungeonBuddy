package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnold on 12/6/2016.
 */

public class weapon extends SugarRecord {
    String damageOneHanded;
    String damageTwoHanded;
    List<String> properties;
    List<String> propertiesDescription;
    String name;
    String cost;
    int weight;
    String description;
    String rarity;
    int equipped;

    public weapon(){
        name = "";
        cost = "";
        weight = 0;
        description = "";
        rarity = "";
        damageOneHanded = "";
        damageTwoHanded = "";
        properties = new ArrayList<>();
        propertiesDescription = new ArrayList<>();
        equipped = 0;
    }

    public weapon(String damageOneHanded, String damageTwoHanded, List<String> properties, List<String> propertiesDescription, String weaponName, String weaponCost, int weaponWeight, String weaponDescription, String weaponRarity, int equipped) {
        name = weaponName;
        cost = weaponCost;
        weight = weaponWeight;
        description = weaponDescription;
        rarity = weaponRarity;
        this.damageOneHanded = damageOneHanded;
        this.damageTwoHanded = damageTwoHanded;
        this.properties = properties;
        this.propertiesDescription = propertiesDescription;
        this.equipped = equipped;
    }
}
