package com.developer.arnold.dungeonbuddy;

import android.os.Bundle;
import android.app.Activity;

public class raceInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_info);

        int testNumber = getIntent().getIntExtra("raceExtraInfoNum", 0);
    }

}
