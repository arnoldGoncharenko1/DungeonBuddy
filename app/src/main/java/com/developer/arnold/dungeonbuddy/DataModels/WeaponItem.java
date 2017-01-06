package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

/**
 * Created by Arnold on 1/5/2017.
 */

public class WeaponItem extends SugarRecord{
    public int characterID;
    public int weaponID;

    public WeaponItem() {
    }

    public WeaponItem(int characterID, int weaponID) {
        this.characterID = characterID;
        this.weaponID = weaponID;
    }

    public int getCharacterID(){
        return characterID;
    }

    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    public int getWeaponId(){
        return weaponID;
    }

    public void setWeaponId(int weaponID){
        this.weaponID = weaponID;
    }
}
