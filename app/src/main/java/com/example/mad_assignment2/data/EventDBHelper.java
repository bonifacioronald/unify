package com.example.mad_assignment2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EventDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EventDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Event";
    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String ORGANIZER_FIELD = "organizer";
    private static final String BACKGROUND_LOGO_URL_FIELD = "backgroundLogoUrl";
    private static final String START_DATE_FIELD = "startDate";
    private static final String END_DATE_FIELD = "endDate";
    private static final String TIME_FIELD = "time";
    private static final String VENDOR_ID_LIST_FIELD = "vendorIdList";


    public EventDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append("(")
                .append(ID_FIELD)
                .append(" STRING PRIMARY KEY AUTOINCREMENT, ")
                .append(TITLE_FIELD)
                .append(" TEXT, ")
                .append(DESCRIPTION_FIELD)
                .append(" TEXT, ")
                .append(ORGANIZER_FIELD)
                .append(" TEXT, ")
                .append(BACKGROUND_LOGO_URL_FIELD)
                .append(" TEXT, ")
                .append(START_DATE_FIELD)
                .append(" DATE, ")
                .append(END_DATE_FIELD)
                .append(" DATE, ")
                .append(TIME_FIELD)
                .append(" TEXT, ")
                .append(VENDOR_ID_LIST_FIELD)
                .append(" TEXT");
        sqLiteDatabase.execSQL(sql.toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public Boolean addNewEventData(String id, String title, String description, String organizer, String backgroundLogoUrl, Date startDate, Date endDate, String time, ArrayList<String> vendorIdList) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Put values into the ContentValues
        contentValues.put(ID_FIELD, id);
        contentValues.put(TITLE_FIELD, title);
        contentValues.put(DESCRIPTION_FIELD, description);
        contentValues.put(ORGANIZER_FIELD, organizer);
        contentValues.put(BACKGROUND_LOGO_URL_FIELD, backgroundLogoUrl);
        contentValues.put(START_DATE_FIELD, dateFormat.format(startDate));
        contentValues.put(END_DATE_FIELD, dateFormat.format(endDate));
        contentValues.put(TIME_FIELD, time);

        // Convert ArrayList of vendor IDs to a comma-separated String
        String vendorIdString = TextUtils.join(",", vendorIdList);
        contentValues.put(VENDOR_ID_LIST_FIELD, vendorIdString);

        long result = DB.insert(TABLE_NAME, null, contentValues);

        return result != -1; // Return true if the insert was successful, otherwise false
    }

    public Boolean updateEventData(String id, String title, String description, String organizer, String backgroundLogoUrl, Date startDate, Date endDate, String time, ArrayList<String> vendorIdList) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Put values into the ContentValues
        contentValues.put(TITLE_FIELD, title);
        contentValues.put(DESCRIPTION_FIELD, description);
        contentValues.put(ORGANIZER_FIELD, organizer);
        contentValues.put(BACKGROUND_LOGO_URL_FIELD, backgroundLogoUrl);

        // Format dates as strings
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        contentValues.put(START_DATE_FIELD, dateFormat.format(startDate));
        contentValues.put(END_DATE_FIELD, dateFormat.format(endDate));

        contentValues.put(TIME_FIELD, time);

        // Convert ArrayList of vendor IDs to a comma-separated String
        String vendorIdString = TextUtils.join(",", vendorIdList);
        contentValues.put(VENDOR_ID_LIST_FIELD, vendorIdString);

        // Check if the event with the given ID exists
        Cursor cursor = DB.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[] {id});

        if (cursor.getCount() > 0) {
            // Event with the given ID exists, update it
            long result = DB.update(TABLE_NAME, contentValues, "id=?", new String[] {id});

            if (result != -1) {
                return true;
            }
        }

        // Event not found or update failed
        return false;
    }

    public Boolean deleteEventData(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        // Check if the event with the given ID exists
        Cursor cursor = DB.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[] {id});

        if (cursor.getCount() > 0) {
            // Event with the given ID exists, update it
            long result = DB.delete(TABLE_NAME,"id=?", new String[] {id});

            if (result != -1) {
                return true;
            }
        }

        // Event not found or update failed
        return false;
    }

    public Cursor getEventData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        // Check if the event with the given ID exists
        Cursor cursor = DB.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
}
