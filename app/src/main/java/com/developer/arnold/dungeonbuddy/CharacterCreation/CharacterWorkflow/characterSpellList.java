package com.developer.arnold.dungeonbuddy.CharacterCreation.CharacterWorkflow;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;

import com.developer.arnold.dungeonbuddy.DataModels.Spell;
import com.developer.arnold.dungeonbuddy.DataModels.playerCharacter;
import com.developer.arnold.dungeonbuddy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnold on 12/28/2016.
 */

public class characterSpellList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_spell_list);

        ListView listview = (ListView) findViewById(R.id.lstCharacterSpell);

        List<String> spellsAvailableList = new ArrayList<String>();
        List<String> spellsDescription = new ArrayList<String>();

        List<Spell> spells = Spell.listAll(Spell.class);

        for(int i = 0; i<spells.size(); i++){
            spellsAvailableList.add(spells.get(i).name);
            spellsDescription.add(spells.get(i).description);
        }

        listview.setAdapter(new spellListAdapter(this, spellsAvailableList, spellsDescription));

    }
}

      class SpellsViewHolder {
          public CheckBox cbSelected;
          public TextView name;
          public TextView description;
          public int position;
    }

    class spellListAdapter extends BaseAdapter {

        Context context;
        List<String> spellName = new ArrayList<String>();
        private static LayoutInflater inflater = null;
        playerCharacter playerChar = new playerCharacter();
        List<String> spellsDescription;
        List<String> spellsSelected = new ArrayList<String>();
        private boolean[] spellsCheck;


        public spellListAdapter(Context context, List<String> spellName, List<String> description) {
            // TODO Auto-generated constructor stub
            this.context = context;
            this.spellName = spellName;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            spellsDescription = description;
            spellsCheck = new boolean[spellName.size()];
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return spellName.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return spellName.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            SpellsViewHolder holder = null;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listview_spell_row, null);
                holder = new SpellsViewHolder();
                holder.cbSelected = (CheckBox) convertView.findViewById(R.id.cbSpell);
                holder.name = (TextView) convertView.findViewById(R.id.spellName);
                holder.description = (TextView) convertView.findViewById(R.id.spellDesc);
                holder.position = position;

                convertView.setTag(holder);
            } else {
                holder = (SpellsViewHolder) convertView.getTag();
            }
           // holder.cbSelected.setOnCheckedChangeListener(null);
            holder.cbSelected.setChecked(spellsCheck[position]);
            //holder.cbSelected.setOnCheckedChangeListener(mStarCheckedChanceChangeListener);

            holder.name.setText(spellName.get(position));
            holder.description.setText(spellsDescription.get(position));

            holder.cbSelected.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(((CheckBox)v).isChecked())
                        spellsCheck[position]=true;
                    else
                        spellsCheck[position]=false;
                }
            });

            Button btnContinueFinalize = (Button) parent.getRootView().findViewById(R.id.btnContinue);
            btnContinueFinalize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for(int i=0; i<spellsCheck.length; i++){
                        if(spellsCheck[i] == true){
                            spellsSelected.add(spellName.get(i));
                        }
                    }
                    if(spellsSelected.size() < 1){
                        createErrorDialog("Error found", "Please choose a Spell");
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


