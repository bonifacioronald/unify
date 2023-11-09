package com.example.mad_assignment2.screens;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment2.R;

public class DirectoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        String pictureName1 = getIntent().getStringExtra("pictureName1");
        String pictureName2 = getIntent().getStringExtra("pictureName2");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        int imageResource1 = getResources().getIdentifier(pictureName1, "drawable", getPackageName());
        int imageResource2 = getResources().getIdentifier(pictureName2, "drawable", getPackageName());
        imageView1.setImageResource(imageResource1);
        imageView2.setImageResource(imageResource2);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
    }
}