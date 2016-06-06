package com.developer.arnold.dungeonbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    /**
     * function that is called when the activity is loaded.
     *
     * @param savedInstanceState    contains the saved instance of the application, containing all necessary information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calls parent constructor and sets the view to a XML file.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * function that is called when a new character wants to be created.
     *
     * @param view  variable that stores the view of the current activity.
     */
    public void createNewCharacter(View view) {
        //creates a intent and starts an activity using that intent.
        Intent intent = new Intent(this, characterRaceList.class);
        startActivity(intent);
    }
}
