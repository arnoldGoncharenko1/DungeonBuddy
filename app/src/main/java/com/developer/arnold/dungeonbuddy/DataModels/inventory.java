package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnold on 12/6/2016.
 */

public class inventory extends SugarRecord {
    List<armor> playerArmors;
    List<Weapon> playerWeapons;
    List<item> playerItems;
    List<Spell> playerSpells;
    int charID;

    public inventory() {
        playerArmors = new ArrayList<>();
        playerWeapons = new ArrayList<>();
        playerItems = new ArrayList<>();
        playerSpells = new ArrayList<>();
        charID = 0;
    }

    public inventory(List<armor> playerArmors, List<Weapon> playerWeapons, List<item> playerItems, List<Spell> playerSpells, int charID) {
        this.playerArmors = playerArmors;
        this.playerWeapons = playerWeapons;
        this.playerItems = playerItems;
        this.playerSpells = playerSpells;
        this.charID = charID;
    }
}
