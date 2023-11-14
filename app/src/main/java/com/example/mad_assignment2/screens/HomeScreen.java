package com.example.mad_assignment2.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_assignment2.R;

public class HomeScreen extends AppCompatActivity {


    private ImageButton drawerButton;
    private TextView dateTextView;
    private  EditText searchEvent;
    private ImageView ongoingEventCard;
    private ImageView upcomingEventCard;
//    private ViewStub drawerStub;
//    private View drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        drawerButton = findViewById(R.id.drawerButton);
        dateTextView = findViewById(R.id.dateTextView);
        searchEvent = findViewById(R.id.searchEvent);
        ongoingEventCard = findViewById(R.id.ongoingEventCard);
        upcomingEventCard = findViewById(R.id.upcomingEventCard);

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMM");
        String today_date = formatter.format(today);

        dateTextView.setText(today_date);

        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, HomeScreenDrawer.class);
                startActivity(intent);
            }
        });


        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, CalendarVisitorScreen.class);
                startActivity(intent);
            }
        });

        //searchEvent function Ignored first
        ongoingEventCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, EventPreviewScreen.class);
                intent.putExtra("event_id",1);
                startActivity(intent);
            }
        });

        upcomingEventCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, EventPreviewScreen.class);
                intent.putExtra("event_id",2);
                startActivity(intent);
            }
        });


    }
}