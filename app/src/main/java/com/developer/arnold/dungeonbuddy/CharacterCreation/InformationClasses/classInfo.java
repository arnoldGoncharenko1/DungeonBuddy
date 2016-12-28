package com.developer.arnold.dungeonbuddy.CharacterCreation.InformationClasses;

import android.app.Activity;
import android.os.Bundle;

import com.developer.arnold.dungeonbuddy.R;

public class classInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int positionChosen = getIntent().getIntExtra("classExtraInfoNum", 0);

        if (positionChosen == 0) {
            setContentView(R.layout.barbarian_info);
        }
        else if (positionChosen == 1) {
            setContentView(R.layout.bard_info);
        }
    }
}
