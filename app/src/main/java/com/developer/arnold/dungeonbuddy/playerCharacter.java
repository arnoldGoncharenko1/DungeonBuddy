package com.developer.arnold.dungeonbuddy;

import java.io.Serializable;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to store all information realted to the player character
 * it implemented the Serializable class so that it can be turned into bytes and be passed
 * from one activty to another.
 */
public class playerCharacter implements Serializable {
    //block of code that stores all player character info (WIP, will be expended)
    String characterName;
    int characterLevel;
    String characterRace;
    int characterExp;
    String characterClass;
    String characterSubClass;
    String characterGender;
    double characterHeight;
    double characterWeight;
    int characterAge;
    String characterAlignment;
}
