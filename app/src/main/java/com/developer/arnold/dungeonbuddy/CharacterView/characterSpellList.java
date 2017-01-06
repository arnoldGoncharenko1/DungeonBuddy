package com.developer.arnold.dungeonbuddy.CharacterView;

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

import com.developer.arnold.dungeonbuddy.DataModels.CharSpell;
import com.developer.arnold.dungeonbuddy.DataModels.Spell;
import com.developer.arnold.dungeonbuddy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnold on 12/28/2016.
 */

public class characterSpellList extends Activity {

    public int charId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_spell_list);

        ListView listview = (ListView) findViewById(R.id.lstCharacterSpell);

        Intent intent = getIntent();
        charId = intent.getIntExtra("charId", 0);


        List<Spell> spells = Spell.listAll(Spell.class);


        listview.setAdapter(new spellListAdapter(this, spells, charId));

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
    List<Spell> spells = new ArrayList<Spell>();
    private static LayoutInflater inflater = null;
    List<Integer> spellsSelected = new ArrayList<Integer>();
    private boolean[] spellsCheck;
    int charId;


    public spellListAdapter(Context context, List<Spell> spells, int charId) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.spells = spells;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        spellsCheck = new boolean[spells.size()];
        this.charId = charId;
        Log.d("charId", String.valueOf(charId));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return spells.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return spells.get(position).getName();
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
            holder.cbSelected = (CheckBox) convertView.findViewById(R.id.cbSelection);
            holder.name = (TextView) convertView.findViewById(R.id.lblName);
            holder.description = (TextView) convertView.findViewById(R.id.lblDesc);
            holder.position = position;

            convertView.setTag(holder);
        } else {
            holder = (SpellsViewHolder) convertView.getTag();
        }
        // holder.cbSelected.setOnCheckedChangeListener(null);
        holder.cbSelected.setChecked(spellsCheck[position]);
        //holder.cbSelected.setOnCheckedChangeListener(mStarCheckedChanceChangeListener);

        holder.name.setText(spells.get(position).getName());
        holder.description.setText(spells.get(position).getDescription());

        holder.cbSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    spellsCheck[position] = true;
                else
                    spellsCheck[position] = false;
            }
        });

        Button btnContinueFinalize = (Button) parent.getRootView().findViewById(R.id.btnContinue);
        btnContinueFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < spellsCheck.length; i++) {
                    if (spellsCheck[i] == true) {
                        spellsSelected.add(spells.get(i).getSpellId());
                    }
                }
                if (spellsSelected.size() < 1) {
                    createErrorDialog("Error found", "Please choose a Spell");
                }

                for(int i=0; i<spellsSelected.size(); i++){
                    CharSpell charSpell = new CharSpell(charId, spellsSelected.get(i));
                    charSpell.save();
                }

                Intent charInfoMain = new Intent(v.getContext(), characterInfoMainActivity.class);
                charInfoMain.putExtra("open_spell", "yes");
                charInfoMain.putExtra("ID", charId);
                v.getContext().startActivity(charInfoMain);
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


