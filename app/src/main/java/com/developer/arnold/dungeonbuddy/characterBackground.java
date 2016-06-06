package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to put together the background of the user's character.
 */
public class characterBackground extends Activity {

    Spinner spinnerSpeciality;
    Spinner spinnerPersonality1;
    Spinner spinnerPersonality2;
    Spinner spinnerIdeal;
    Spinner spinnerBond;
    Spinner spinnerFlaw;
    Spinner spinnerBackgroundSaving;

    playerCharacter userCharacter;

    /**
     * function that is called when the activity is loaded.
     *
     * @param savedInstanceState    contains the saved instance of the application, containing all necessary information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_background);

        spinnerSpeciality = (Spinner) findViewById(R.id.charSpecialty);
        spinnerPersonality1 = (Spinner) findViewById(R.id.charTraitOne);
        spinnerPersonality2 = (Spinner) findViewById(R.id.charTraitTwo);
        spinnerIdeal = (Spinner) findViewById(R.id.charIdeal);
        spinnerBond = (Spinner) findViewById(R.id.charBond);
        spinnerFlaw = (Spinner) findViewById(R.id.charFlaw);
        spinnerBackgroundSaving = (Spinner) findViewById(R.id.charBackground);

        userCharacter = (playerCharacter) getIntent().getSerializableExtra("userCharacterObject");

        final Spinner spinnerBackground = (Spinner) findViewById(R.id.charBackground);
        spinnerBackground.setOnItemSelectedListener(
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
                        Spinner spinnerSpeciality = (Spinner) findViewById(R.id.charSpecialty);
                        Spinner spinnerPersonality1 = (Spinner) findViewById(R.id.charTraitOne);
                        Spinner spinnerPersonality2 = (Spinner) findViewById(R.id.charTraitTwo);
                        Spinner spinnerIdeal = (Spinner) findViewById(R.id.charIdeal);
                        Spinner spinnerBond = (Spinner) findViewById(R.id.charBond);
                        Spinner spinnerFlaw = (Spinner) findViewById(R.id.charFlaw);

                        //if first position is chosen, all the spinners are disables and return back to thier old state
                        if (position == 0) {
                            ArrayAdapter<String> adapterEmpty = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.emptyBackgroundDetails));

                            spinnerSpeciality.setAdapter(adapterEmpty);
                            spinnerPersonality1.setAdapter(adapterEmpty);
                            spinnerPersonality2.setAdapter(adapterEmpty);
                            spinnerIdeal.setAdapter(adapterEmpty);
                            spinnerBond.setAdapter(adapterEmpty);
                            spinnerFlaw.setAdapter(adapterEmpty);

                            enableDisableSpinner(0);
                        }

                        //if second position is chosen, shows the all the associated parts of the background.
                        if (position == 1) {
                            ArrayAdapter<String> adapterSpeciality = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.backgroundSpecialSoldier));
                            ArrayAdapter<String> adapterPersonality = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.backgroundPersonalitySoldier));
                            ArrayAdapter<String> adapterIdeal = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.backgroundIdealSoldier));
                            ArrayAdapter<String> adapterBond = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.backgroundBondSoldier));
                            ArrayAdapter<String> adapterFlaw = new ArrayAdapter<String>(characterBackground.this, R.layout.spinnerdialogbox, R.id.lblOption, getResources().getStringArray(R.array.backgroundFlawSoldier));

                            enableDisableSpinner(1);

                            spinnerSpeciality.setAdapter(adapterSpeciality);
                            spinnerPersonality1.setAdapter(adapterPersonality);
                            spinnerPersonality2.setAdapter(adapterPersonality);
                            spinnerIdeal.setAdapter(adapterIdeal);
                            spinnerBond.setAdapter(adapterBond);
                            spinnerFlaw.setAdapter(adapterFlaw);
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
     * function that is called when a spinner has to be enabled or disabled.
     *
     * @param enableDisable input that determines if the spinner's should be enabled or disables
     */
    public void enableDisableSpinner(int enableDisable) {
        if (enableDisable == 0) {
            spinnerSpeciality.setEnabled(false);
            spinnerPersonality1.setEnabled(false);
            spinnerPersonality2.setEnabled(false);
            spinnerIdeal.setEnabled(false);
            spinnerBond.setEnabled(false);
            spinnerFlaw.setEnabled(false);
        }
        else if (enableDisable == 1) {
            spinnerSpeciality.setEnabled(true);
            spinnerPersonality1.setEnabled(true);
            spinnerPersonality2.setEnabled(true);
            spinnerIdeal.setEnabled(true);
            spinnerBond.setEnabled(true);
            spinnerFlaw.setEnabled(true);
        }
    }

    /**
     * function that is called when the user clickes on the button to continue
     *
     * @param view  contains the view where this function will belong too
     */
    public void chooseClass(View view) {
        if (checkIfEmpty()) {
            //goes to the next part of the character creation process
            Intent intent = new Intent(this, characterClass.class);
            intent.putExtra("userCharacterObject", userCharacter);
            startActivity(intent);
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

        //checks if any of the spinner's have the correct position (Anything other then the first position)
        if (spinnerBackgroundSaving.getSelectedItemPosition() == 0) {
            errorMessage += "Please choose a background!\n";
            submissionPassed=false;
        }
        if (spinnerPersonality2.getSelectedItemPosition() == spinnerPersonality1.getSelectedItemPosition() && spinnerPersonality2.isEnabled() == true) {
            errorMessage += "Please choose a second personality trait (can't be the same!)\n";
            submissionPassed=false;
        }

        //if all the submissions have been passed then the information is assigned inside the userCharacter object
        //and will be passed to the next activity. if any of the values are wrong then an error is shown.
        if (!submissionPassed) {
            createErrorDialog(errorMessage, "Error found");
            return false;
        }
        else {
            userCharacter.characterBackground = spinnerBackgroundSaving.getSelectedItem().toString().trim();
            userCharacter.characterSpecialty = spinnerSpeciality.getSelectedItem().toString().trim();
            userCharacter.characterTraits[0] = spinnerPersonality1.getSelectedItem().toString().trim();
            userCharacter.characterTraits[1] = spinnerPersonality2.getSelectedItem().toString().trim();
            userCharacter.characterIdeal = spinnerIdeal.getSelectedItem().toString().trim();
            userCharacter.characterBond = spinnerBond.getSelectedItem().toString().trim();
            userCharacter.characterFlaw = spinnerFlaw.getSelectedItem().toString().trim();
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
