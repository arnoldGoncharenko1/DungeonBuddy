package com.developer.arnold.dungeonbuddy.CharacterCreation.InformationClasses;

import android.app.Activity;
import android.os.Bundle;

import com.developer.arnold.dungeonbuddy.R;

public class raceInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int positionChosen = getIntent().getIntExtra("raceExtraInfoNum", 0);

        if (positionChosen == 0) {
            setContentView(R.layout.dwarf_desc);
        }
        else if (positionChosen == 1) {
            setContentView(R.layout.human_desc);
        }
    }
}
