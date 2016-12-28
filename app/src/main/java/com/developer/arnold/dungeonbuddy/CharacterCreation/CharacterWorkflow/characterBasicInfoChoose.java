package com.developer.arnold.dungeonbuddy.CharacterCreation.CharacterWorkflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.developer.arnold.dungeonbuddy.DataModels.playerCharacter;
import com.developer.arnold.dungeonbuddy.MainActivity;
import com.developer.arnold.dungeonbuddy.HelperClasses.MySQLiteHelper;
import com.developer.arnold.dungeonbuddy.R;

public class characterBasicInfoChoose extends AppCompatActivity {

    playerCharacter playerChar = new playerCharacter();
    MySQLiteHelper dbHelper = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_basic_info_choose);

        TextView HitPointsNum = (TextView) findViewById(R.id.lblHitPointsNum);

        playerChar = (playerCharacter)getIntent().getSerializableExtra("playerCharIntent");

        int charHealth = 0;

        if (playerChar.characterClass.equals("Barbarian")) {
            charHealth = 12 + playerChar.characterStats[2];
            HitPointsNum.setText(Integer.toString(charHealth));
        }
        else if (playerChar.characterClass.equals("Bard")) {
            charHealth = 8 + playerChar.characterStats[2];
            HitPointsNum.setText(Integer.toString(charHealth));
        }

        playerChar.characterHealth = charHealth;
        playerChar.characterLevel = 1;
    }

    public void GoBackToStartingScreen(View view) {
        EditText charName = (EditText) findViewById(R.id.edtCharName);
        playerChar.characterName = charName.getText().toString();
        dbHelper.addCharacter(playerChar);
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
