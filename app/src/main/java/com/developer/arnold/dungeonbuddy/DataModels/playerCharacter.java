package com.developer.arnold.dungeonbuddy.DataModels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to store all information realted to the player character
 * it implemented the Serializable class so that it can be turned into bytes and be passed
 * from one activty to another.
 */
public class playerCharacter implements Serializable {
    //block of code that stores all player character info (WIP, will be expended)
    public int characterID;
    public String characterName;
    public int characterLevel;
    public String characterRace;
    public int characterExp;
    public String characterClass;
    public int[] characterStats;
    public List<String> characterProfs;
    public int characterHealth;
    public String characterBackground;
    public inventory characterInventory;

    public playerCharacter () {
        characterID = 0;
        characterStats = new int[6];
        characterProfs = new ArrayList<String>();
        characterName = "";
        characterLevel = 0;
        characterRace = "";
        characterExp = 0;
        characterClass = "";
        characterHealth = 0;
        characterBackground = "";
    }

    public playerCharacter(int characterID, String characterName, int characterLevel, String characterRace, int characterExp, String characterClass, int[] characterStats, List<String> characterProfs, int characterHealth, String characterBackground) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.characterRace = characterRace;
        this.characterExp = characterExp;
        this.characterClass = characterClass;
        this.characterStats = characterStats;
        this.characterProfs = characterProfs;
        this.characterHealth = characterHealth;
        this.characterBackground = characterBackground;
    }
}
