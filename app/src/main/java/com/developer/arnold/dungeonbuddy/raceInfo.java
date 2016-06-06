package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.os.Bundle;

public class raceInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int testVar = getIntent().getIntExtra("raceExtraInfoNum", 0);

        if (testVar == 0) {
            setContentView(R.layout.dwarf_desc);
        }
        else {
            setContentView(R.layout.activity_race_info);
        }
    }
}
