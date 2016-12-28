package com.developer.arnold.dungeonbuddy.DataModels;

import com.orm.SugarRecord;

/**
 * Created by Arnold on 12/28/2016.
 */

public class spell extends SugarRecord {

    String name;
    String description;

    public spell(){
        name = "";
        description = "";
    }

    public spell (String name, String description){
        this.name = name;
        this.description = description;
    }
}
