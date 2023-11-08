package com.example.mad_assignment2.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment2.R;

public class DirectoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_details_screen);


        ImageButton button1 = findViewById(R.id.imageButton1);
        button1.setOnClickListener(view -> openDetailActivity("dic01", "insideScoop"));

        ImageButton button2 = findViewById(R.id.imageButton2);
        button1.setOnClickListener(view -> openDetailActivity("dic02", "domino"));

        ImageButton button3 = findViewById(R.id.imageButton3);
        button1.setOnClickListener(view -> openDetailActivity("dic03", "McDonald"));

        ImageButton button4 = findViewById(R.id.imageButton4);
        button1.setOnClickListener(view -> openDetailActivity("dic04", "chanel"));

        ImageButton button5 = findViewById(R.id.imageButton5);
        button1.setOnClickListener(view -> openDetailActivity("dic05", "balenciaga"));

        ImageButton button6 = findViewById(R.id.imageButton6);
        button1.setOnClickListener(view -> openDetailActivity("dic06", "uniqlo"));

//        ImageButton button7 = findViewById(R.id.imageView2);
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DirectoryActivity.this, EventPreviewPage.class);
//                startActivity(intent);
//            }
//        });
        // button go to activity_event_preview_page
    }

    private void openDetailActivity(String pictureName, String text) {
        Intent intent = new Intent(DirectoryActivity.this, DirectoryDetailActivity.class);
        intent.putExtra("PICTURE_NAME", pictureName);
        intent.putExtra("TEXT", text);
        startActivity(intent);
    }
}
