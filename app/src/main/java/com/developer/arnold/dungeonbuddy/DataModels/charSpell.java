package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

/**
 * Created by Arnold on 1/4/2017.
 */

public class charSpell extends SugarRecord {

    public int characterID;
    public int spellId;

    public charSpell(){

    }

    public charSpell (int characterID, int spellId){
        this.characterID = characterID;
        this.spellId = spellId;
    }

    public int getCharacterID(){
        return characterID;
    }

    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    public int getSpellId(){
        return spellId;
    }

    public void setSpellId(int spellId){
        this.spellId = spellId;
    }
}
