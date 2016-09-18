package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class characterStats extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);
    }

    public void scoreStrButton(View view) {
        TableRow strengthRow = (TableRow) view.getParent();

        Button strPlus = (Button) strengthRow.findViewById(R.id.btnStrPlus);
        Button strMinus = (Button) strengthRow.findViewById(R.id.btnStrMinus);
        TextView strScore = (TextView) strengthRow.findViewById(R.id.lblStrScore);
        TextView strMod = (TextView) strengthRow.findViewById(R.id.lblStrMod);
        TextView strSave = (TextView) strengthRow.findViewById(R.id.lblStrSave);
        LinearLayout parentTable = (LinearLayout) strengthRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentStrScore = Integer.parseInt(strScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());
        
        boolean strPlusPressed = strPlus.isPressed();
        boolean strMinusPressed = strMinus.isPressed();

        if (strPlusPressed && currentPoints > 0) {
            if (currentStrScore < 15) {
                currentStrScore++;
                if (currentStrScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                strScore.setText(Integer.toString(currentStrScore));
                if (currentStrScore >= 10) {
                    int newMod = (int)(currentStrScore - 10) / 2;
                    strMod.setText(Integer.toString(newMod));
                    strSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentStrScore <= 9) {
                    int newMod = (int)Math.round((currentStrScore - 10 - 0.1) / 2.0);
                    strMod.setText(Integer.toString(newMod));
                    strSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (strMinusPressed) {
            if (currentStrScore > 8) {
                currentStrScore--;
                if (currentStrScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                strScore.setText(Integer.toString(currentStrScore));
                if (currentStrScore <= 9) {
                    int newMod = (int)Math.round((currentStrScore - 10 - 0.1) / 2.0);
                    strMod.setText(Integer.toString(newMod));
                    strSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentStrScore >= 10) {
                    int newMod = (int)(currentStrScore - 10) / 2;
                    strMod.setText(Integer.toString(newMod));
                    strSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }

    public void scoreDexButton (View view) {
        TableRow dexterityRow = (TableRow) view.getParent();

        Button dexPlus = (Button) dexterityRow.findViewById(R.id.btnDexPlus);
        Button dexMinus = (Button) dexterityRow.findViewById(R.id.btnDexMinus);
        TextView dexScore = (TextView) dexterityRow.findViewById(R.id.lblDexScore);
        TextView dexMod = (TextView) dexterityRow.findViewById(R.id.lblDexMod);
        TextView dexSave = (TextView) dexterityRow.findViewById(R.id.lblDexSave);
        LinearLayout parentTable = (LinearLayout) dexterityRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentDexScore = Integer.parseInt(dexScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());

        boolean dexPlusPressed = dexPlus.isPressed();
        boolean dexMinusPressed = dexMinus.isPressed();

        if (dexPlusPressed && currentPoints > 0) {
            if (currentDexScore < 15) {
                currentDexScore++;
                if (currentDexScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                dexScore.setText(Integer.toString(currentDexScore));
                if (currentDexScore >= 10) {
                    int newMod = (int)(currentDexScore - 10) / 2;
                    dexMod.setText(Integer.toString(newMod));
                    dexSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentDexScore <= 9) {
                    int newMod = (int)Math.round((currentDexScore - 10 - 0.1) / 2.0);
                    dexMod.setText(Integer.toString(newMod));
                    dexSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (dexMinusPressed) {
            if (currentDexScore > 8) {
                currentDexScore--;
                if (currentDexScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                dexScore.setText(Integer.toString(currentDexScore));
                if (currentDexScore <= 9) {
                    int newMod = (int)Math.round((currentDexScore - 10 - 0.1) / 2.0);
                    dexMod.setText(Integer.toString(newMod));
                    dexSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentDexScore >= 10) {
                    int newMod = (int)(currentDexScore - 10) / 2;
                    dexMod.setText(Integer.toString(newMod));
                    dexSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }

    public void scoreConButton (View view) {
        TableRow constituionRow = (TableRow) view.getParent();

        Button conPlus = (Button) constituionRow.findViewById(R.id.btnConPlus);
        Button conMinus = (Button) constituionRow.findViewById(R.id.btnConMinus);
        TextView conScore = (TextView) constituionRow.findViewById(R.id.lblConScore);
        TextView conMod = (TextView) constituionRow.findViewById(R.id.lblConMod);
        TextView conSave = (TextView) constituionRow.findViewById(R.id.lblConSave);
        LinearLayout parentTable = (LinearLayout) constituionRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentConScore = Integer.parseInt(conScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());

        boolean conPlusPressed = conPlus.isPressed();
        boolean conMinusPressed = conMinus.isPressed();

        if (conPlusPressed && currentPoints > 0) {
            if (currentConScore < 15) {
                currentConScore++;
                if (currentConScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                conScore.setText(Integer.toString(currentConScore));
                if (currentConScore >= 10) {
                    int newMod = (int)(currentConScore - 10) / 2;
                    conMod.setText(Integer.toString(newMod));
                    conSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentConScore <= 9) {
                    int newMod = (int)Math.round((currentConScore - 10 - 0.1) / 2.0);
                    conMod.setText(Integer.toString(newMod));
                    conSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (conMinusPressed) {
            if (currentConScore > 8) {
                currentConScore--;
                if (currentConScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                conScore.setText(Integer.toString(currentConScore));
                if (currentConScore <= 9) {
                    int newMod = (int)Math.round((currentConScore - 10 - 0.1) / 2.0);
                    conMod.setText(Integer.toString(newMod));
                    conSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentConScore >= 10) {
                    int newMod = (int)(currentConScore - 10) / 2;
                    conMod.setText(Integer.toString(newMod));
                    conSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }

    public void scoreIntButton (View view) {
        TableRow intelligenceRow = (TableRow) view.getParent();

        Button intPlus = (Button) intelligenceRow.findViewById(R.id.btnIntPlus);
        Button intMinus = (Button) intelligenceRow.findViewById(R.id.btnIntMinus);
        TextView intScore = (TextView) intelligenceRow.findViewById(R.id.lblIntScore);
        TextView intMod = (TextView) intelligenceRow.findViewById(R.id.lblIntMod);
        TextView intSave = (TextView) intelligenceRow.findViewById(R.id.lblIntSave);
        LinearLayout parentTable = (LinearLayout) intelligenceRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentIntScore = Integer.parseInt(intScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());

        boolean intPlusPressed = intPlus.isPressed();
        boolean intMinusPressed = intMinus.isPressed();

        if (intPlusPressed && currentPoints > 0) {
            if (currentIntScore < 15) {
                currentIntScore++;
                if (currentIntScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                intScore.setText(Integer.toString(currentIntScore));
                if (currentIntScore >= 10) {
                    int newMod = (int)(currentIntScore - 10) / 2;
                    intMod.setText(Integer.toString(newMod));
                    intSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentIntScore <= 9) {
                    int newMod = (int)Math.round((currentIntScore - 10 - 0.1) / 2.0);
                    intMod.setText(Integer.toString(newMod));
                    intSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (intMinusPressed) {
            if (currentIntScore > 8) {
                currentIntScore--;
                if (currentIntScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                intScore.setText(Integer.toString(currentIntScore));
                if (currentIntScore <= 9) {
                    int newMod = (int)Math.round((currentIntScore - 10 - 0.1) / 2.0);
                    intMod.setText(Integer.toString(newMod));
                    intSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentIntScore >= 10) {
                    int newMod = (int)(currentIntScore - 10) / 2;
                    intMod.setText(Integer.toString(newMod));
                    intSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }

    public void scoreWisButton (View view) {
        TableRow wisdomRow = (TableRow) view.getParent();

        Button wisPlus = (Button) wisdomRow.findViewById(R.id.btnWisPlus);
        Button wisMinus = (Button) wisdomRow.findViewById(R.id.btnWisMinus);
        TextView wisScore = (TextView) wisdomRow.findViewById(R.id.lblWisScore);
        TextView wisMod = (TextView) wisdomRow.findViewById(R.id.lblWisMod);
        TextView wisSave = (TextView) wisdomRow.findViewById(R.id.lblWisSave);
        LinearLayout parentTable = (LinearLayout) wisdomRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentWisScore = Integer.parseInt(wisScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());

        boolean wisPlusPressed = wisPlus.isPressed();
        boolean wisMinusPressed = wisMinus.isPressed();

        if (wisPlusPressed && currentPoints > 0) {
            if (currentWisScore < 15) {
                currentWisScore++;
                if (currentWisScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                wisScore.setText(Integer.toString(currentWisScore));
                if (currentWisScore >= 10) {
                    int newMod = (int)(currentWisScore - 10) / 2;
                    wisMod.setText(Integer.toString(newMod));
                    wisSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentWisScore <= 9) {
                    int newMod = (int)Math.round((currentWisScore - 10 - 0.1) / 2.0);
                    wisMod.setText(Integer.toString(newMod));
                    wisSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (wisMinusPressed) {
            if (currentWisScore > 8) {
                currentWisScore--;
                if (currentWisScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                wisScore.setText(Integer.toString(currentWisScore));
                if (currentWisScore <= 9) {
                    int newMod = (int)Math.round((currentWisScore - 10 - 0.1) / 2.0);
                    wisMod.setText(Integer.toString(newMod));
                    wisSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentWisScore >= 10) {
                    int newMod = (int)(currentWisScore - 10) / 2;
                    wisMod.setText(Integer.toString(newMod));
                    wisSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }

    public void scoreChaButton (View view) {
        TableRow charismaRow = (TableRow) view.getParent();

        Button chaPlus = (Button) charismaRow.findViewById(R.id.btnChaPlus);
        Button chaMinus = (Button) charismaRow.findViewById(R.id.btnChaMinus);
        TextView chaScore = (TextView) charismaRow.findViewById(R.id.lblChaScore);
        TextView chaMod = (TextView) charismaRow.findViewById(R.id.lblChaMod);
        TextView chaSave = (TextView) charismaRow.findViewById(R.id.lblChaSave);
        LinearLayout parentTable = (LinearLayout) charismaRow.getParent().getParent();
        TextView pointsLeft = (TextView) parentTable.findViewById(R.id.lblPointsLeftNum);

        int currentChaScore = Integer.parseInt(chaScore.getText().toString());
        int currentPoints = Integer.parseInt(pointsLeft.getText().toString());

        boolean chaPlusPressed = chaPlus.isPressed();
        boolean chaMinusPressed = chaMinus.isPressed();

        if (chaPlusPressed && currentPoints > 0) {
            if (currentChaScore < 15) {
                currentChaScore++;
                if (currentChaScore > 13){
                    currentPoints = currentPoints - 2;
                }
                else {
                    currentPoints--;
                }
                chaScore.setText(Integer.toString(currentChaScore));
                if (currentChaScore >= 10) {
                    int newMod = (int)(currentChaScore - 10) / 2;
                    chaMod.setText(Integer.toString(newMod));
                    chaSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
                else if (currentChaScore <= 9) {
                    int newMod = (int)Math.round((currentChaScore - 10 - 0.1) / 2.0);
                    chaMod.setText(Integer.toString(newMod));
                    chaSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
        else if (chaMinusPressed) {
            if (currentChaScore > 8) {
                currentChaScore--;
                if (currentChaScore >= 13){
                    currentPoints = currentPoints + 2;
                }
                else {
                    currentPoints++;
                }
                chaScore.setText(Integer.toString(currentChaScore));
                if (currentChaScore <= 9) {
                    int newMod = (int)Math.round((currentChaScore - 10 - 0.1) / 2.0);
                    chaMod.setText(Integer.toString(newMod));
                    chaSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));

                }
                else if (currentChaScore >= 10) {
                    int newMod = (int)(currentChaScore - 10) / 2;
                    chaMod.setText(Integer.toString(newMod));
                    chaSave.setText(Integer.toString(newMod));
                    pointsLeft.setText(Integer.toString(currentPoints));
                }
            }
        }
    }
}
