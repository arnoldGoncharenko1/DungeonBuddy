package com.developer.arnold.dungeonbuddy;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class createBasicCharFeatures extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_basic_char_features);

        Spinner raceSpinner = (Spinner) findViewById(R.id.raceSpinner);

        raceSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()
                {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        Spinner raceSpinner = (Spinner) findViewById(R.id.raceSpinner);
                        TextView raceDesc = (TextView) findViewById(R.id.lblRaceDesc);
                        String choosenRace = raceSpinner.getSelectedItem().toString();

                        if (choosenRace.equals("Dwarf")){
                            raceDesc.setText("Ability Score increase: +2 Constitution\n" +
                                             "Age: 1-350 years old\n" +
                                             "Alignment: Most Are Lawful\n" +
                                             "Size: 4-5 Feet Tall, 1-150+ Pounds, Medium\n" +
                                             "Speed: 25 Feet\n" +
                                             "Darkvision: can see 60 feet in the dark\n" +
                                             "Dwarven Resilience: Advantage on poison saving throws and resistence on poison\n" +
                                             "Dwarven Combat Training: proficiency: battleaxe, handaxe, light hammer, warhammer\n" +
                                             "Tool Proficiency: 1 of smith's tools, brewer's supplies, mason's tools\n" +
                                             "Stonecutting: double proficiency on stone history checks\n" +
                                             "Languages: Common, Dwarvish");
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                });
    }

}
