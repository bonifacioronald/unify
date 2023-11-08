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

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        String pictureName = getIntent().getStringExtra("PICTURE_NAME");
        String text = getIntent().getStringExtra("TEXT");

        int imageResId = getResources().getIdentifier(pictureName, "drawable", getPackageName());
        imageView.setImageResource(imageResId);
        textView.setText(text);
    }
}