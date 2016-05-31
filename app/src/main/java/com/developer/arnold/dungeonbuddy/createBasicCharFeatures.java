package com.developer.arnold.dungeonbuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class createBasicCharFeatures extends Activity {

    //primary object//
    playerCharacter userCharacter;

    /**
     * function that is called when the activity is loaded.
     *
     * @param savedInstanceState    contains the saved instance of the application, containing all necessary information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_basic_char_features);

        //creates a new player object to be used as a player character.
        userCharacter = new playerCharacter();

        //creates a spinner object that will let the user choose a race his character will be.
        Spinner raceSpinner = (Spinner) findViewById(R.id.charRace);
        raceSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()
                {
                    /**
                     * function that is called when another spinner option is chosen.
                     *
                     * @param parent    object that contains the parent of the spinner (In this case LinearLayout)
                     * @param view      object that has the view that the spinner belongs too.
                     * @param position  int varible that contains the current index of the spinner (defaults to 0)
                     * @param id        long variable that contains the of the spinner.
                     */
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        //creates a textview object to assign the race description too.
                        TextView raceDesc = (TextView) findViewById(R.id.lblRaceDesc);

                        //if first position is chosen, shows default race description.
                        if (position == 0) {
                            raceDesc.setText("Race description will appear here");
                        }

                        //if second position is chosen, shows the dwarf description.
                        if (position == 1){
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

                    /**
                     * function that is called when no spinner option is selected
                     *
                     * @param parent    object that contains the parent of the spinner (In this case LinearLayout)
                     */
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    /**
     * function that is called when the user is finished with the form and would like to move to the next step
     * of the player creation process which is class selection (WIP).
     *
     * @param view      variable that stores the view of the current activity.
     */
    public void charChooseClass (View view) {
        //checks if the input is not empty and if it's the right format.
        if (checkInput()) {
            //creates a error dialog (Temporary) to warn the user that it was a success
            createErrorDialog("Succesfully passed all validation!", "Success!");
        }
    }

    public boolean checkInput () {
        if (checkIfEmpty()) {
            if (checkIfCorrectFormat()) {
                return true;
            }
        }
        return false;
    }

    public void createErrorDialog(String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView dialogErrorMessage = new TextView(this);
        dialogErrorMessage.setText(message);
        dialogErrorMessage.setGravity(Gravity.CENTER_HORIZONTAL);

        builder.setView(dialogErrorMessage);
        builder.setTitle(title);

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean checkIfEmpty() {

        EditText edtCharName = (EditText) findViewById(R.id.edtCharName);
        EditText edtCharGender = (EditText) findViewById(R.id.edtCharGender);
        EditText edtCharHeight = (EditText) findViewById(R.id.edtCharHeight);
        EditText edtCharWeight = (EditText) findViewById(R.id.edtCharWeight);
        EditText edtCharAge = (EditText) findViewById(R.id.edtCharAge);

        Spinner levelSpinner = (Spinner) findViewById(R.id.charLevel);
        Spinner alignmentSpinner = (Spinner) findViewById(R.id.charAlignment);
        Spinner raceSpinner = (Spinner) findViewById(R.id.charRace);

        String errorMessage="";
        boolean submissionPassed=true;

        if (edtCharName.getText().toString().trim().length() == 0) {
            errorMessage += "Character name is empty! please input a name for your character\n";
            submissionPassed=false;
        }
        if (edtCharGender.getText().toString().trim().length() == 0) {
            errorMessage += "Character gender is empty! please input a gender for your character\n";
            submissionPassed=false;
        }
        if (edtCharHeight.getText().toString().trim().length() == 0) {
            errorMessage += "Character height is empty! please input a height for your character\n";
            submissionPassed=false;
        }
        if (edtCharWeight.getText().toString().trim().length() == 0) {
            errorMessage += "Character weight is empty! please input a weight for your character\n";
            submissionPassed=false;
        }
        if (edtCharAge.getText().toString().trim().length() == 0) {
            errorMessage += "Character age is empty! please input a age for your character\n";
            submissionPassed=false;
        }

        if (levelSpinner.getSelectedItemPosition() == 0) {
            errorMessage += "Please choose a level\n";
            submissionPassed=false;
        }
        if (alignmentSpinner.getSelectedItemPosition() == 0) {
            errorMessage += "Please choose a alignment\n";
            submissionPassed=false;
        }
        if (raceSpinner.getSelectedItemPosition() == 0) {
            errorMessage += "Please choose a race\n";
            submissionPassed=false;
        }

        if (!submissionPassed) {
            createErrorDialog(errorMessage, "Error found");
            return false;
        }
        else {

            return true;
        }
    }

    public boolean checkIfCorrectFormat() {
        double charHeight=0;
        int charWeight=0;
        int charAge=0;
        boolean formatPassed=true;
        String errorMessage="";

        EditText edtCharHeight = (EditText) findViewById(R.id.edtCharHeight);
        EditText edtCharWeight = (EditText) findViewById(R.id.edtCharWeight);
        EditText edtCharAge = (EditText) findViewById(R.id.edtCharAge);

        try {
            charHeight = Double.parseDouble(edtCharHeight.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            errorMessage += "Please type in a number between 1-9 (ex. 3.4) for height\n";
            edtCharHeight.setTextColor(Color.RED);
            formatPassed=false;
        }

        try {
            charWeight = Integer.parseInt(edtCharWeight.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            errorMessage += "Please type in a number between 1-300 for weight\n";
            edtCharWeight.setTextColor(Color.RED);
            formatPassed=false;
        }

        try {
            charAge = Integer.parseInt(edtCharAge.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            errorMessage += "Please type in a number between 1-1000 for age\n";
            edtCharAge.setTextColor(Color.RED);
            formatPassed=false;
        }

        if (!formatPassed) {
            createErrorDialog(errorMessage, "Error: Incorrect format type");
            return false;
        }
        else {
            userCharacter.characterHeight = charHeight;
            userCharacter.characterWeight = charWeight;
            userCharacter.characterAge = charAge;
            return true;
        }
    }
}
