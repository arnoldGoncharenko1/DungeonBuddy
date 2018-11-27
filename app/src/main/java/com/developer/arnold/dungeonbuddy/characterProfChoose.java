package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class characterProfChoose extends Activity {

    playerCharacter playerChar = new playerCharacter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_prof_choose);

        List<String> profsAvailableList = new ArrayList<String>();
        int maxProfs = 0;

        ListView listview = (ListView) findViewById(R.id.lstProfList);
        playerChar = (playerCharacter)getIntent().getSerializableExtra("playerCharIntent");

        if (playerChar.characterClass.equals("Barbarian")) {
            profsAvailableList.add("Animal Handling (Wis)");
            profsAvailableList.add("Athletics (Str)");
            profsAvailableList.add("Intimidation (Cha)");
            profsAvailableList.add("Nature (Int)");
            profsAvailableList.add("Perception (Wis)");
            profsAvailableList.add("Survival (Wis)");
            maxProfs = 2;
        }
        else if (playerChar.characterClass.equals("Bard")) {
            profsAvailableList.add("Animal Handling (Wis)");
            profsAvailableList.add("Athletics (Str)");
            profsAvailableList.add("Intimidation (Cha)");
            profsAvailableList.add("Nature (Int)");
            profsAvailableList.add("Perception (Wis)");
            profsAvailableList.add("Survival (Wis)");
            profsAvailableList.add("Acrobatics (Dex)");
            profsAvailableList.add("Arcana (Int)");
            profsAvailableList.add("Deception (Cha)");
            profsAvailableList.add("History (Wis)");
            profsAvailableList.add("Insight (Wis)");
            profsAvailableList.add("Investigation (Int)");
            profsAvailableList.add("Medicine (Wis)");
            profsAvailableList.add("Performance (Cha)");
            profsAvailableList.add("Persuasion (Cha)");
            profsAvailableList.add("Religion (Int)");
            profsAvailableList.add("Sleight of Hand (Dex)");
            profsAvailableList.add("Stealth (Dex)");
            maxProfs = 3;
        }

        listview.setAdapter(new profListAdapter(this, profsAvailableList.toArray(new String[profsAvailableList.size()]), maxProfs));
    }
}

class profListAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;
    private CheckBox mSelectedRB;
    private int mSelectedPosition = -1;
    private int maxNumSelected = 0;
    playerCharacter playerChar = new playerCharacter();
    List<String> profsSelected = new ArrayList<String>();
    int maxProfs;

    public profListAdapter(Context context, String[] data, int maxProfs) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.maxProfs = maxProfs;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
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
            vi = inflater.inflate(R.layout.listview_prof_item_row, null);

        Button btnContinueFinalize = (Button) parent.getRootView().findViewById(R.id.btnContinueFinalize);
        final CheckBox cbProfChoose = (CheckBox) vi.findViewById(R.id.cbProf);

        cbProfChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cbProfChoose.isChecked()) {
                    maxNumSelected--;
                    profsSelected.remove(cbProfChoose.getText().toString());
                    return;
                }
                if (maxNumSelected == maxProfs) {
                    cbProfChoose.setChecked(false);
                    return;
                }
                else {
                    maxNumSelected++;
                    profsSelected.add(cbProfChoose.getText().toString());
                }
            }
        });

        if (mSelectedPosition != position) {
            cbProfChoose.setChecked(false);
        } else {
            cbProfChoose.setChecked(true);
            if (mSelectedRB != null && cbProfChoose != mSelectedRB) {
                mSelectedRB = cbProfChoose;
            }
        }

        btnContinueFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxNumSelected == maxProfs) {
                    playerChar = (playerCharacter)((Activity) context).getIntent().getSerializableExtra("playerCharIntent");
                    playerChar.characterProfs.addAll(profsSelected);
                    Intent intent = new Intent(context, characterBasicInfoChoose.class);
                    intent.putExtra("playerCharIntent", playerChar);
                    context.startActivity(intent);
                } else {
                    createErrorDialog("Error found", "Please choose " + (maxProfs - maxNumSelected) + " more proficiencie(s)!");
                }
            }
        });

        cbProfChoose.setText(data[position]);

        return vi;
    }

    /**
     * function that is called when a error dialog has to be created.
     *
     * @param message String that has the message body to be displayed.
     * @param title   String that has the title of the error dialog.
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
