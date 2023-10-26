package com.example.mad_assignment2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mad_assignment2.models.Vendor;

import java.util.ArrayList;

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
}
