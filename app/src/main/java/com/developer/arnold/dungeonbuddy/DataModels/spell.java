package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

/**
 * Created by Arnold on 12/28/2016.
 */

public class Spell extends SugarRecord {

    public int spellId;
    public String name;
    public String description;


    public Spell(){
        name = "";
        description = "";
    }

    public Spell(int spellId, String name, String description){
        this.spellId = spellId;
        this.name = name;
        this.description = description;
    }

    public int getSpellId(){
        return spellId;
    }

    public void setSpellId(int spellId){
        this.spellId = spellId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}

