package com.example.mad_assignment2.screens;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.mad_assignment2.R;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment2.data.RatingDatabaseHelper;

public class DetailActivityScreen extends AppCompatActivity {
    private RatingDatabaseHelper dbHelper;
    private RatingBar ratingBar;
    private TextView averageRatingView;
    private int buttonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        backButton = findViewById(R.id.backButton);

        // Initialize database helper
        dbHelper = new RatingDatabaseHelper(this);

        // Get the button ID from the intent
        buttonId = getIntent().getIntExtra("BUTTON_ID", 0);

        // Initialize views
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ratingBar = findViewById(R.id.ratingBar);
        averageRatingView = findViewById(R.id.averageRatingTextView);

        // Set content based on the button ID
        setDetailContent(buttonId);

        // Load average rating from database and set it
        float averageRating = dbHelper.getAverageRating(buttonId);
        if (averageRating != -1) { // Assuming -1 denotes an error or no rating
            ratingBar.setRating(averageRating);
            averageRatingView.setText(String.format("Average Rating: %.2f", averageRating));
        }

        // Set the RatingBar change listener
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    saveRatingToDatabase(buttonId, rating);
                    // Update the average rating after a new rating is added
                    float newAverageRating = dbHelper.getAverageRating(buttonId);
                    averageRatingView.setText(String.format("Average Rating: %.2f", newAverageRating));
                }
            }
        });
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivityScreen.this, EventDetailScreen.class);
                startActivity(intent);
            }
        });
    }

    private void setDetailContent(int buttonId) {
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        switch (buttonId) {
            case 1:
                // set button 1 content
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("aa");
                descriptionTextView.setText("bb");
                break;

            case 2:
                // set button 2 content
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("aa");
                descriptionTextView.setText("b");
                break;

            case 3:
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("bb");
                descriptionTextView.setText("b");
                break;
            case 4:
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("cc");
                descriptionTextView.setText("cc");
                break;
            case 5:
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("bb");
                descriptionTextView.setText("b");
                break;
            case 6:
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("ee");
                descriptionTextView.setText("b");
                break;
            default:
                imageView1.setImageResource(R.drawable.dic01);
                imageView2.setImageResource(R.drawable.dic01);
                titleTextView.setText("a");
                descriptionTextView.setText("b");
                break;
        }
    }

    private void saveRatingToDatabase(int buttonId, float rating) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RatingDatabaseHelper.COLUMN_BUTTON_ID, buttonId);
        values.put(RatingDatabaseHelper.COLUMN_RATING, rating);

        // Insert new rating or update existing rating in the database
        db.insertWithOnConflict(RatingDatabaseHelper.TABLE_RATINGS, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        db.close();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}

