package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class characterClass extends Activity {

    playerCharacter userCharacter;

    Spinner spinnerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_class);

        userCharacter = (playerCharacter) getIntent().getSerializableExtra("userCharacterObject");

        spinnerClass = (Spinner) findViewById(R.id.charClass);

        spinnerClass.setOnItemSelectedListener(
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
                        TextView classDescText = (TextView) findViewById(R.id.lblClassDesc);

                        //if first position is chosen, all the spinners are disables and return back to thier old state
                        if (position == 0) {
                            classDescText.setText("Class description goes here");
                        }

                        //if second position is chosen, shows the all the associated parts of the class.
                        if (position == 1) {
                            classDescText.setText("Hit Dice: 1d12 per barbarian level.\n" +
                                    "Hit Points at 1st Level: 12 + your Constitution modifier.\n" +
                                    "Hit Points at Higher Levels: 1d12 your Constitution modifier per level after 1st\n" +
                                    "Proficient (Armor): Light armor, Medium armor, shields\n" +
                                    "Proficient (Weapons): Simple weapons, martial weapons\n" +
                                    "Saving Throws: Strength, Constitution\n" +
                                    "Skills: (Choose two) Animal Handling, Athletics, Intimidation, Nature, Perception, Survival\n" +
                                    "Equipment: (a) Great axe or (b) any martial weapon\n" +
                                    "Equipment: (a) Two handaxes or (b) any simple weapon" +
                                    "Equipment: An explorer's pack and four javelins");
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
     * function that is called when the user clickes on the button to continue
     *
     * @param view  contains the view where this function will belong too
     */
    public void chooseStatPoints(View view) {
        if (checkIfEmpty()) {
            createErrorDialog("Success!", "Successfully validated");
        }
        return;
    }

    /**
     * function that checks if everything has been selected for the characters background;
     *
     * @return returns if all the validation passes!
     */
    public boolean checkIfEmpty() {

        String errorMessage="";
        boolean submissionPassed=true;

        Spinner spinnerClass = (Spinner) findViewById(R.id.charClass);

        //checks if any of the spinner's have the correct position (Anything other then the first position)
        if (spinnerClass.getSelectedItemPosition() == 0) {
            errorMessage += "Please select a class!";
            submissionPassed = false;
        }

        //if all the submissions have been passed then the information is assigned inside the userCharacter object
        //and will be passed to the next activity. if any of the values are wrong then an error is shown.
        if (!submissionPassed) {
            createErrorDialog(errorMessage, "Error found");
            return false;
        }
        else {
            userCharacter.characterClass = spinnerClass.getSelectedItem().toString().trim();

            return true;
        }
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
}
