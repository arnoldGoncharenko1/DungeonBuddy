package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnold on 12/6/2016.
 */

public class Weapon extends SugarRecord {
    public int weaponID;
    public String damageOneHanded;
    public String damageTwoHanded;
    public String name;
    public String cost;
    public int weight;
    public String description;
    public String rarity;
    public int equipped;

    public Weapon(){
        name = "";
        cost = "";
        weight = 0;
        description = "";
        rarity = "";
        damageOneHanded = "";
        damageTwoHanded = "";
        equipped = 0;
    }

    public Weapon(int weaponID, String damageOneHanded, String damageTwoHanded, String weaponName, String weaponCost, int weaponWeight, String weaponDescription, String weaponRarity, int equipped) {
        this.weaponID = weaponID;
        name = weaponName;
        cost = weaponCost;
        weight = weaponWeight;
        description = weaponDescription;
        rarity = weaponRarity;
        this.damageOneHanded = damageOneHanded;
        this.damageTwoHanded = damageTwoHanded;
        this.equipped = equipped;
    }

    public int getWeaponId(){
        return weaponID;
    }

    public void setWeaponId(int weaponID){
        this.weaponID = weaponID;
    }

    public String getDamageOneHanded(){
        return damageOneHanded;
    }

    public void setDamageOneHanded(String damageOneHanded){
        this.damageOneHanded = damageOneHanded;
    }

    public String getdamageTwoHanded(){
        return damageTwoHanded;
    }

    public void setdamageTwoHanded(String damageTwoHanded){
        this.damageTwoHanded = damageTwoHanded;
    }

    public String getWeaponName(){
        return name;
    }

    public void setWeaponName(String name){
        this.name = name;
    }

    public String getWeaponCost(){
        return cost;
    }

    public void setWeaponCost(String cost){
        this.cost = cost;
    }

    public int getWeaponWeight(){
        return weight;
    }

    public void setWeaponWeight(int weight){
        this.weight = weight;
    }

    public String getWeaponDescription(){
        return description;
    }

    public void setWeaponDescription(String description){
        this.description = description;
    }

    public String getWeaponRarity(){
        return rarity;
    }

    public void setWeaponRarity(String rarity){
        this.rarity = rarity;
    }

    public int getWeaponEquipped(){
        return equipped;
    }

    public void setWeaponEquipped(int equipped){
        this.equipped = equipped;
    }
}
