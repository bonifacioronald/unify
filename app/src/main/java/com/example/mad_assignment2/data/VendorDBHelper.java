package com.example.mad_assignment2.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mad_assignment2.models.Vendor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class VendorDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "VendorDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Vendor";
    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "name";
    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "password";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String CATEGORY_FIELD = "category";
    private static final String IMAGE_URL_FIELD = "imageUrl";
    private static final String RATING_FIELD = "rating";
    private static final String BOOTH_LOCATION_FIELD = "boothLocation";

    public VendorDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " (" +
                ID_FIELD + " STRING PRIMARY KEY, " +
                NAME_FIELD + " TEXT, " +
                EMAIL_FIELD + " TEXT, " +
                PASSWORD_FIELD + " TEXT, " +
                DESCRIPTION_FIELD + " TEXT, " +
                CATEGORY_FIELD + " TEXT, " +
                IMAGE_URL_FIELD + " TEXT, " +
                RATING_FIELD + " REAL, " +
                BOOTH_LOCATION_FIELD + " INTEGER)";
        sqLiteDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Boolean initializeVendorData() throws Exception {
        SQLiteDatabase DB = this.getWritableDatabase();

        // Check if the database is empty
        Cursor cursor = DB.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();

        Log.d("Database Initialization", "Current row count: " + count);

        // If the database is empty, add initial vendors
        if (count == 0) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            ArrayList<Vendor> initialVendors = VendorInitData.initializeVendorToArrayList();

            // Insert initial vendors into the database
            for (Vendor vendor : initialVendors) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(ID_FIELD, vendor.getId());
                contentValues.put(NAME_FIELD, vendor.getName());
                contentValues.put(EMAIL_FIELD, vendor.getEmail());
                contentValues.put(PASSWORD_FIELD, vendor.getPassword());
                contentValues.put(DESCRIPTION_FIELD, vendor.getDescription());
                contentValues.put(CATEGORY_FIELD, vendor.getCategory());
                contentValues.put(IMAGE_URL_FIELD, vendor.getImageUrl());
                contentValues.put(RATING_FIELD, vendor.getRating());
                contentValues.put(BOOTH_LOCATION_FIELD, vendor.getBoothLocation());

                long result = DB.insert(TABLE_NAME, null, contentValues);

                if (result == -1) {
                    Log.d("Database Initialization", "Insert failed for vendor with ID: " + vendor.getId());
                    return false; // If any insertion fails, return false
                } else {
                    Log.d("Database Initialization", "Insert successful for vendor with ID: " + vendor.getId());
                }
            }

            return true; // All initial vendors inserted successfully
        } else {
            Log.d("Database Initialization", "Database is not empty, no need to initialize");
            return false; // Database is not empty, no need to initialize
        }
    }

    public boolean addNewVendor(Vendor vendor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_FIELD, vendor.getId());
        values.put(NAME_FIELD, vendor.getName());
        values.put(EMAIL_FIELD, vendor.getEmail());
        values.put(PASSWORD_FIELD, vendor.getPassword());
        values.put(DESCRIPTION_FIELD, vendor.getDescription());
        values.put(CATEGORY_FIELD, vendor.getCategory());
        values.put(IMAGE_URL_FIELD, vendor.getImageUrl());
        values.put(RATING_FIELD, vendor.getRating());
        values.put(BOOTH_LOCATION_FIELD, vendor.getBoothLocation());

        long result = db.insert(TABLE_NAME, null, values);
        db.close();

        return result != -1;
    }

    public boolean updateVendorData(Vendor vendor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, vendor.getName());
        values.put(EMAIL_FIELD, vendor.getEmail());
        values.put(PASSWORD_FIELD, vendor.getPassword());
        values.put(DESCRIPTION_FIELD, vendor.getDescription());
        values.put(CATEGORY_FIELD, vendor.getCategory());
        values.put(IMAGE_URL_FIELD, vendor.getImageUrl());
        values.put(RATING_FIELD, vendor.getRating());
        values.put(BOOTH_LOCATION_FIELD, vendor.getBoothLocation());

        int result = db.update(TABLE_NAME, values, ID_FIELD + " = ?", new String[]{vendor.getId()});
        db.close();

        return result > 0;
    }

    public boolean deleteVendor(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, ID_FIELD + " = ?", new String[]{id});
        db.close();

        return result > 0;
    }

    public Cursor getVendorData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        // Check if the event with the given ID exists
        Cursor cursor = DB.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    public void logVendorData() {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(ID_FIELD));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(NAME_FIELD));

                    Log.d("Database Content", "ID: " + id + " | Name: " + name);

                    // Add more fields as needed
                } while (cursor.moveToNext());
            } else {
                Log.d("Database Content", "No data found in the database.");
            }
        } catch (Exception e) {
            Log.e("Database Content", "Error logging data: " + e.getMessage());
        } finally {
            cursor.close();
        }
    }

    public void clearDatabase() {
        SQLiteDatabase DB = this.getWritableDatabase();

        // Delete all records from the table
        DB.delete(TABLE_NAME, null, null);

        // Close the database connection
        DB.close();
    }


}
