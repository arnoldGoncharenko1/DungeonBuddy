package com.developer.arnold.dungeonbuddy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.developer.arnold.dungeonbuddy.CharacterCreation.CharacterWorkflow.characterRaceList;
import com.developer.arnold.dungeonbuddy.CharacterView.characterInfoMainActivity;
import com.developer.arnold.dungeonbuddy.DataModels.Spell;
import com.developer.arnold.dungeonbuddy.DataModels.Weapon;
import com.developer.arnold.dungeonbuddy.DataModels.playerCharacter;
import com.developer.arnold.dungeonbuddy.HelperClasses.MySQLiteHelper;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<playerCharacter> playersCharacters;
    List<Integer> listOfCharacterIDs = new ArrayList<>();

    /**
     * function that is called when the activity is loaded.
     *
     * @param savedInstanceState    contains the saved instance of the application, containing all necessary information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calls parent constructor and sets the view to a XML file.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);
        MySQLiteHelper db = new MySQLiteHelper(this);

        long count = Spell.count(Spell.class);
        if(count == 0){
            addSpells();
        }

        long weaponCount = Weapon.count(Weapon.class);
        if(weaponCount == 0) {
            addWeapons();
        }

        //db.destroyDB(this);

        playersCharacters = db.getAllContacts();

        for (int i= 0; i < playersCharacters.size(); i++) {
            listOfCharacterIDs.add(playersCharacters.get(i).characterID);
        }

        final charListAdapter adapter = new charListAdapter(this, playersCharacters);

        ListView listview = (ListView) findViewById(R.id.charListView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), characterInfoMainActivity.class);
                int retreivedCharacterId = listOfCharacterIDs.get(position);
                intent.putExtra("ID", retreivedCharacterId);
                startActivity(intent);
            }
        });


    }

    /**
     * function that is called when a new character wants to be created.
     *
     * @param view  variable that stores the view of the current activity.
     */
    public void createNewCharacter(View view) {
        //creates a intent and starts an activity using that intent.
        Intent intent = new Intent(this, characterRaceList.class);
        startActivity(intent);
    }

    public void addSpells(){
        Spell spell1 = new Spell (1, "Acid Splash", "Hurl a bubble of acid");
        spell1.save();
        Spell spell2 = new Spell (2, "Aid", "Bolsters your allies with toughness and resolve");
        spell2.save();
        Spell spell3 = new Spell (3, "Alarm", "Alerts you whenever a tiny or larger creature touches or enters the warded area");
        spell3.save();
        Spell spell4 = new Spell (4, "Animate Dead", "Creates a undead servant");
        spell4.save();
        Spell spell5 = new Spell (5, "Animal Friendship", "Lets you convince a beast that you mean it no harm");
        spell5.save();
        Spell spell6 = new Spell (6, "Arcane Eye", "Creates an invisible eye within range that hovers in the air");
        spell6.save();
        Spell spell7 = new Spell (7, "Bane", "Up to three creatures that you can see must make Charisma saving throws");
        spell7.save();
        Spell spell8 = new Spell (8, "Beacon of Hope", "Bestows hope and vitality");
        spell8.save();
        Spell spell9 = new Spell (9, "Blindness", "You can blind of deaf a foe");
        spell9.save();
        Spell spell10 = new Spell (10, "Blur", "Your body becomes blurred, shifting to all who can see you");
        spell10.save();
        Spell spell11 = new Spell (11, "Chain Lightning", "Creates a bolt of lightning that arcs towards a target");
        spell11.save();
        Spell spell12 = new Spell (12, "Chromatic Orb", "Hurl a 4-inch-diameter sphere of energy at a creature");
        spell12.save();
    }

    public void addWeapons(){
        Weapon weapon1 = new Weapon (1, "1d4 bludgeoning", "1d4 bludgeoning", "Club", "1 sp", 2, "Light", "Common", 0);
        weapon1.save();
        Weapon weapon2 = new Weapon (2, "1d4 piercing", "1d4 piercing", "Dagger", "2 gp", 1, "Finesse, light, thrown (range 20/60)", "Common", 0);
        weapon2.save();
        Weapon weapon3 = new Weapon (3, "1d8 bludgeoning", "1d8 bludgeoning", "Greatclub", "2 sp", 10, "Two-Handed", "Common", 0);
        weapon3.save();
        Weapon weapon4 = new Weapon (4, "1d6 slashing", "1d6 slashing", "Handaxe", "5 gp", 2, "Light, thrown (range 20/60)", "Common", 0);
        weapon4.save();
        Weapon weapon5 = new Weapon (5, "1d6 piercing", "1d6 piercing", "Javelin", "5 sp", 2, "thrown (range 30/120)", "Common", 0);
        weapon5.save();
        Weapon weapon6 = new Weapon (6, "1d4 bludgeoning", "1d4 bludgeoning", "Light Hammer", "2 gp", 2, "Light, thrown (range 20/60)", "Common", 0);
        weapon6.save();
    }
}

class charListAdapter extends BaseAdapter {
    Context context;
    ArrayList<playerCharacter> data;
    private static LayoutInflater inflater = null;
    private RadioButton mSelectedRB;
    private int mSelectedPosition = -1;

    public charListAdapter(Context context, ArrayList<playerCharacter> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi;
        vi = convertView;

        if (vi == null)
            vi = inflater.inflate(R.layout.list_view_character, null);

        TextView charName = (TextView) vi.findViewById(R.id.lblCharacterNameList);
        TextView charLevel = (TextView) vi.findViewById(R.id.lblCharacterLevelList);
        TextView charClass = (TextView) vi.findViewById(R.id.lblCharacterClassList);
        TextView charExp = (TextView) vi.findViewById(R.id.lblCharacterExpList);

        charName.setText(data.get(position).characterName);
        charLevel.setText(String.valueOf(data.get(position).characterLevel));
        charClass.setText(data.get(position).characterClass);
        charExp.setText(String.valueOf(data.get(position).characterExp));

        return vi;
    }

    /**
     * function that is called when a error dialog has to be created.
     *
     * @param message   String that has the message body to be displayed.
     * @param title     String that has the title of the error dialog.
     */
    public void createErrorDialog(String title, String message) {

        //block of code that creates a error dialog using the message and title provided
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        TextView dialogErrorMessage = new TextView(context);
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
