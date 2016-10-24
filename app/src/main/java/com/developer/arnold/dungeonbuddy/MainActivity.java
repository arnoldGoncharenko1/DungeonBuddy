package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends AppCompatActivity {

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

        MySQLiteHelper db = new MySQLiteHelper(this);

        db.destroyDB(this);

        ArrayList<playerCharacter> playersCharacters = new ArrayList<playerCharacter>();

        playersCharacters = db.getAllContacts();

        ListView listview = (ListView) findViewById(R.id.charListView);
        listview.setAdapter(new charListAdapter(this, playersCharacters));
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
