package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.os.Bundle;

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
