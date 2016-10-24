package com.developer.arnold.dungeonbuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to assist with assigning and storing basic features of the character.
 * this is the first step in the character creation process.
 */
public class createBasicCharFeatures extends Activity {

    //object that will be used to store the in-progress user character
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

        //Set up of listeners that will change the text back to white if user doesn't type in the right input and the error message turns the
        //text red.
        EditText edtCharacterAge = (EditText) findViewById(R.id.edtCharAge);
        edtCharacterAge.setOnTouchListener(
                new View.OnTouchListener() {
                    /**
                     * function that is called when the edit text is clicked by the user
                     *
                     * @param view  variable that stores the view of the current activity.
                     */
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        EditText edtCharacterAge = (EditText) findViewById(R.id.edtCharAge);
                        edtCharacterAge.setTextColor(Color.WHITE);
                        return false;
                    }
                }
        );
        EditText edtCharacterWeight = (EditText) findViewById(R.id.edtCharWeight);
        edtCharacterWeight.setOnTouchListener(
                new View.OnTouchListener() {
                    /**
                     * function that is called when the edit text is clicked by the user
                     *
                     * @param view  variable that stores the view of the current activity.
                     */
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        EditText edtCharacterWeight = (EditText) findViewById(R.id.edtCharWeight);
                        edtCharacterWeight.setTextColor(Color.WHITE);
                        return false; // return is important...
                    }
                }
        );
        EditText edtCharacterHeight = (EditText) findViewById(R.id.edtCharHeight);
        edtCharacterHeight.setOnTouchListener(
                new View.OnTouchListener() {
                    /**
                     * function that is called when the edit text is clicked by the user
                     *
                     * @param view  variable that stores the view of the current activity.
                     */
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        EditText edtCharacterHeight = (EditText) findViewById(R.id.edtCharHeight);
                        edtCharacterHeight.setTextColor(Color.WHITE);
                        return false;
                    }
                }
        );
        EditText edtCharacterExp = (EditText) findViewById(R.id.edtStartExp);
        edtCharacterExp.setOnTouchListener(
                new View.OnTouchListener() {
                    /**
                     * function that is called when the edit text is clicked by the user
                     *
                     * @param view  variable that stores the view of the current activity.
                     */
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        EditText edtCharacterExp = (EditText) findViewById(R.id.edtStartExp);
                        edtCharacterExp.setTextColor(Color.WHITE);
                        return false;
                    }
                }
        );

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
    public void charChooseBackground (View view) {
        //checks if the input is not empty and if it's the right format.
        if (checkInput()) {
            //goes to the next part of the character creation process
            Intent intent = new Intent(this, characterBackground.class);
            intent.putExtra("userCharacterObject", userCharacter);
            startActivity(intent);
        }
    }

    /**
     * function that is called to check the user's input into the form. if it passes both tests it was a success and the next step
     * can be made, if not, then the user should fix the problems on the form.
     *
     * @return  returns a true or false depending on whatever or not the input was correct.
     */
    public boolean checkInput () {
        //goes through two checks. first is to check if all the values are filled out, the second checks if some of the values are
        //a correct format.
        if (checkIfEmpty()) {
            if (checkIfCorrectFormat()) {
                return true;
            }
        }
        return false;
    }

    /**
     * function that is called when a error dialog has to be created.
     *
     * @param message   String that has the message body to be displayed.
     * @param title     String that has the title of the error dialog.
     */
    public void createErrorDialog(String message, String title) {

        //block of code that creates a error dialog using the message and title provided
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        TextView dialogErrorMessage = new TextView(this);
        dialogErrorMessage.setText(message);
        dialogErrorMessage.setGravity(Gravity.CENTER_HORIZONTAL);

        dialogBuilder.setView(dialogErrorMessage);
        dialogBuilder.setTitle(title);

        //creates a button so the user can close the dialog
        dialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            /**
             * function that is called when the button in the dialog is pressed
             *
             * @param dialog    object containing the dialog that is currently in use.
             * @param id        int value that contains the dialogs ID.
             */
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    /**
     * function that checks if any of the fields needed are empty and assigns ones that aren't.
     *
     * @return  returns a true or false depending on whatever or not the input was filled out.
     */
    public boolean checkIfEmpty() {

        //block of code that creates a large variety of edit text's and spinners so that they
        //can be checked if thier empty.
        EditText edtCharName = (EditText) findViewById(R.id.edtCharName);
        EditText edtCharGender = (EditText) findViewById(R.id.edtCharGender);
        EditText edtCharHeight = (EditText) findViewById(R.id.edtCharHeight);
        EditText edtCharWeight = (EditText) findViewById(R.id.edtCharWeight);
        EditText edtCharAge = (EditText) findViewById(R.id.edtCharAge);

        Spinner levelSpinner = (Spinner) findViewById(R.id.charLevel);
        Spinner alignmentSpinner = (Spinner) findViewById(R.id.charAlignment);
        Spinner raceSpinner = (Spinner) findViewById(R.id.charRace);

        //block of code that declares an "all clear" boolean value and a error message to be used
        //with the error dialog box
        String errorMessage="";
        boolean submissionPassed=true;

        //block of code that checks if any of the edit text's are empty
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

        //checks if any of the spinner's have the correct position (Anything other then the first position)
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

        //if all the submissions have been passed then the information is assigned inside the userCharacter object
        //and will be passed to the next activity. if any of the values are wrong then an error is shown.
        if (!submissionPassed) {
            createErrorDialog(errorMessage, "Error found");
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * function that checks if any of the fields have the correct format.
     *
     * @return  returns a true or false depending on whatever or not the input was the correct format.
     */
    public boolean checkIfCorrectFormat() {

        //initial variables declares to help test if the correct format has been used
        double charHeight=0;
        int charWeight=0;
        int charAge=0;
        int charExp=0;

        //block of code that declares an "all clear" boolean value and a error message to be used
        //with the error dialog box
        boolean formatPassed=true;
        String errorMessage="";

        //a group of edit texts to help with later validation.
        EditText edtCharHeight = (EditText) findViewById(R.id.edtCharHeight);
        EditText edtCharWeight = (EditText) findViewById(R.id.edtCharWeight);
        EditText edtCharAge = (EditText) findViewById(R.id.edtCharAge);
        EditText edtCharExp = (EditText) findViewById(R.id.edtStartExp);

        //group of try-catch statements to see if the height, age, and weight values are the correct format.
        try {
            //parses the string, if a double is acquired then it's all clear, if not, an exception is thrown.
            charHeight = Double.parseDouble(edtCharHeight.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            //block of code that adds a error message, changes the text and color to warn the user that something is wrong.
            errorMessage += "Please type in a number between for height (ex. 3.4)\n";
            edtCharHeight.setText(edtCharHeight.getText().toString().trim() + " (Height)");
            edtCharHeight.setTextColor(Color.RED);
            formatPassed=false;
        }

        try {
            //parses the string, if a integer is acquired then it's all clear, if not, an exception is thrown.
            charWeight = Integer.parseInt(edtCharWeight.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            //block of code that adds a error message, changes the text and color to warn the user that something is wrong.
            errorMessage += "Please type in a number between for weight\n";
            edtCharWeight.setText(edtCharWeight.getText().toString().trim() + " (Weight)");
            edtCharWeight.setTextColor(Color.RED);
            formatPassed=false;
        }

        try {
            //parses the string, if a integer is acquired then it's all clear, if not, an exception is thrown.
            charAge = Integer.parseInt(edtCharAge.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            //block of code that adds a error message, changes the text and color to warn the user that something is wrong.
            errorMessage += "Please type in a number between for age\n";
            edtCharAge.setText(edtCharAge.getText().toString().trim() + " (Age)");
            edtCharAge.setTextColor(Color.RED);
            formatPassed=false;
        }

        try {
            //parses the string, if a double is acquired then it's all clear, if not, an exception is thrown.
            charExp = Integer.parseInt(edtCharExp.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            //block of code that adds a error message, changes the text and color to warn the user that something is wrong.
            errorMessage += "Please type in a number for exp\n";
            edtCharExp.setText(edtCharExp.getText().toString().trim() + " (Exp)");
            edtCharExp.setTextColor(Color.RED);
            formatPassed=false;
        }

        //if everything is correct, the values are assigned to the user character, and a true is returned, if not then
        //a error is shown and all the problems are highlighted by the program.
        if (!formatPassed) {
            createErrorDialog(errorMessage, "Error: Incorrect format type");
            return false;
        }
        else {
            userCharacter.characterExp = charExp;
            return true;
        }
    }
}
