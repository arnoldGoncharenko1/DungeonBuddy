package com.developer.arnold.dungeonbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.app.DownloadManager.COLUMN_ID;

/**
 * Created by Arnold on 6/6/2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static class FeedEntry implements BaseColumns {
        //Basic info
        public static final String TABLE_NAME = "playerCharacters";
        public static final String COLUMN_NAME_CHARACTER_NAME = "charName";
        public static final String COLUMN_NAME_CHARACTER_LEVEL = "charLevel";
        public static final String COLUMN_NAME_CHARACTER_RACE = "charRace";
        public static final String COLUMN_NAME_CHARACTER_EXP = "charExp";
        public static final String COLUMN_NAME_CHARACTER_CLASS = "charClass";
        public static final String COLUMN_NAME_CHARACTER_HEALTH = "charHealth";
        public static final String COLUMN_NAME_CHARACTER_BACKGROUND = "charBackground";

        //Stats
        public static final String COLUMN_NAME_CHARACTER_STATS = "charStats";
        public static final String COLUMN_NAME_CHARACTER_PROFS = "charProfs";

        //Checking variables
        public static final String COLUMN_NAME_CHARACTER_CREATED = "charCreated";
    }

    private static final String DATABASE_NAME = "Characters.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + FeedEntry.TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + FeedEntry.COLUMN_NAME_CHARACTER_NAME
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_LEVEL
            + " integer, " + FeedEntry.COLUMN_NAME_CHARACTER_RACE
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_EXP
            + " integer, " + FeedEntry.COLUMN_NAME_CHARACTER_CLASS
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_STATS
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_PROFS
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_BACKGROUND
            + " text, " + FeedEntry.COLUMN_NAME_CHARACTER_HEALTH
            + " integer);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public void destroyDB(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }

    public void addCharacter(playerCharacter playerChar)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String tempStatsAndProfs = "";

        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_NAME, playerChar.characterName);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_LEVEL, playerChar.characterLevel);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_RACE, playerChar.characterRace);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_EXP, playerChar.characterExp);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_CLASS, playerChar.characterClass);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_BACKGROUND, playerChar.characterBackground);
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_HEALTH, playerChar.characterHealth);

        for (int i=0; i < playerChar.characterStats.length; i++) {
            tempStatsAndProfs +=  playerChar.characterStats[i] + " ";
        }
        values.put(FeedEntry.COLUMN_NAME_CHARACTER_STATS, tempStatsAndProfs.trim());

        values.put(FeedEntry.COLUMN_NAME_CHARACTER_PROFS, TextUtils.join(",", playerChar.characterProfs));

        // Inserting Row
        db.insert(FeedEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public ArrayList<playerCharacter> getAllContacts() {
        ArrayList<playerCharacter> playerList = new ArrayList<playerCharacter>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FeedEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                playerCharacter playerChar = new playerCharacter();
                playerChar.characterName = cursor.getString(1);
                playerChar.characterLevel = cursor.getInt(2);
                playerChar.characterClass = cursor.getString(5);
                playerChar.characterExp = cursor.getInt(4);
                playerList.add(playerChar);
            } while (cursor.moveToNext());
        }

        // return contact list
        return playerList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME);
        onCreate(db);
    }

    public void createDatabaseFromScratch(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
}
