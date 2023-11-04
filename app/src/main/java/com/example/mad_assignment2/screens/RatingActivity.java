package com.example.mad_assignment2.screens;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_assignment2.R;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_assignment2.data.RatingsContract;
import com.example.mad_assignment2.data.RatingsDbHelper;

public class RatingActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView avgRatingView;
    private RatingsDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        avgRatingView = findViewById(R.id.avgRating);

        dbHelper = new RatingsDbHelper(this);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                saveRatingToDatabase(rating);
                updateAverageRating();
            }
        });

        updateAverageRating();
    }

    private void saveRatingToDatabase(float rating) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RatingsContract.RatingEntry.COLUMN_RATING, rating);

        long newRowId = db.insert(RatingsContract.RatingEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {

            Toast.makeText(this, "Error with saving rating", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Rating saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateAverageRating() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT AVG(" + RatingsContract.RatingEntry.COLUMN_RATING + ") FROM " + RatingsContract.RatingEntry.TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            double averageRating = cursor.getDouble(0);
            avgRatingView.setText(String.format("Average Rating: %.1f", averageRating));
            cursor.close();
        }
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}