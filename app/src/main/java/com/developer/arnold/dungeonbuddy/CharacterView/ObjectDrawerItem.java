package com.developer.arnold.dungeonbuddy.CharacterView;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to store the information to create every item in the drawer.
 */
public class ObjectDrawerItem {
    //a block of code that creates a reference to the icon and the name of the drawer item.
    public int icon;
    public String name;

    /**
     * default constructor that assigns the icon and the name of the drawe item.
     */
    public ObjectDrawerItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }
}