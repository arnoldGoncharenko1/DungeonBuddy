package com.developer.arnold.dungeonbuddy;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Comment;

public class characterRaceList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_race_list);

        ListView listview = (ListView) findViewById(R.id.lstCharacterRace);
        listview.setAdapter(new raceListAdapter(this, new String[] { "Dwarf", "Human" }));
    }
}



class raceListAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;
    private RadioButton mSelectedRB;
    private int mSelectedPosition = -1;
    playerCharacter playerChar = new playerCharacter();

    public raceListAdapter(Context context, String[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            vi = inflater.inflate(R.layout.list_view_item, null);

        Button btnContinueClass = (Button) parent.getRootView().findViewById(R.id.btnContinue);
        final RadioButton raceName = (RadioButton) vi.findViewById(R.id.radioRace);
        Button btnMoreInfo = (Button) vi.findViewById(R.id.btnMoreRaceInfo);

        raceName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != mSelectedPosition && mSelectedRB != null){
                    mSelectedRB.setChecked(false);
                }
                mSelectedPosition = position;
                mSelectedRB = (RadioButton)v;
            }
        });

        if(mSelectedPosition != position){
            raceName.setChecked(false);
        }else{
            raceName.setChecked(true);
            if(mSelectedRB != null && raceName != mSelectedRB){
                mSelectedRB = raceName;
            }
        }

        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, raceInfo.class);
                intent.putExtra("raceExtraInfoNum", position);
                context.startActivity(intent);
            }
        });

        btnContinueClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectedPosition != -1) {
                    playerChar.characterRace = mSelectedRB.getText().toString();
                    Intent intent = new Intent(context, characterClassList.class);
                    intent.putExtra("playerCharIntent", playerChar);
                    context.startActivity(intent);
                } else {
                    createErrorDialog("Error found", "Please choose a race!");
                }
            }
        });

        raceName.setText(data[position]);

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