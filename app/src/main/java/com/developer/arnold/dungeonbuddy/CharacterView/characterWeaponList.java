package com.developer.arnold.dungeonbuddy.CharacterView;

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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.developer.arnold.dungeonbuddy.DataModels.CharSpell;
import com.developer.arnold.dungeonbuddy.DataModels.Spell;
import com.developer.arnold.dungeonbuddy.DataModels.Weapon;
import com.developer.arnold.dungeonbuddy.DataModels.WeaponItem;
import com.developer.arnold.dungeonbuddy.R;

import java.util.ArrayList;
import java.util.List;

public class characterWeaponList extends AppCompatActivity {

    public int charId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_weapon_list);

        ListView listview = (ListView) findViewById(R.id.lstCharacterWeapons);

        Intent intent = getIntent();
        charId = intent.getIntExtra("charId", 0);

        List<Weapon> weapons = Weapon.listAll(Weapon.class);

        listview.setAdapter(new weaponListAdapter(this, weapons, charId));
    }
}

class WeaponsViewHolder {
    public CheckBox cbSelected;
    public TextView name;
    public TextView description;
    public int position;
}

class weaponListAdapter extends BaseAdapter {

    Context context;
    List<Weapon> weapons = new ArrayList<Weapon>();
    private static LayoutInflater inflater = null;
    List<Integer> weaponsSelected = new ArrayList<Integer>();
    private boolean[] weaponsCheck;
    int charId;


    public weaponListAdapter(Context context, List<Weapon> weapons, int charId) {
        this.context = context;
        this.weapons = weapons;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        weaponsCheck = new boolean[weapons.size()];
        this.charId = charId;
        Log.d("charId", String.valueOf(charId));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return weapons.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return weapons.get(position).getWeaponName();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        WeaponsViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_spell_row, null);
            holder = new WeaponsViewHolder();
            holder.cbSelected = (CheckBox) convertView.findViewById(R.id.cbSelection);
            holder.name = (TextView) convertView.findViewById(R.id.lblName);
            holder.description = (TextView) convertView.findViewById(R.id.lblDesc);
            holder.position = position;

            convertView.setTag(holder);
        } else {
            holder = (WeaponsViewHolder) convertView.getTag();
        }
        // holder.cbSelected.setOnCheckedChangeListener(null);
        holder.cbSelected.setChecked(weaponsCheck[position]);
        //holder.cbSelected.setOnCheckedChangeListener(mStarCheckedChanceChangeListener);

        holder.name.setText(weapons.get(position).getWeaponName());
        holder.description.setText(weapons.get(position).getWeaponDescription());

        holder.cbSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    weaponsCheck[position] = true;
                else
                    weaponsCheck[position] = false;
            }
        });

        Button btnContinueFinalize = (Button) parent.getRootView().findViewById(R.id.btnContinue);
        btnContinueFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < weaponsCheck.length; i++) {
                    if (weaponsCheck[i] == true) {
                        weaponsSelected.add(weapons.get(i).getWeaponId());
                    }
                }
                if (weaponsSelected.size() < 1) {
                    createErrorDialog("Error found", "Please choose a Spell");
                }

                for(int i=0; i<weaponsSelected.size(); i++){
                    WeaponItem weaponItem = new WeaponItem(charId, weaponsSelected.get(i));
                    weaponItem.save();
                }
            }
        });

        return convertView;
    }

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
