package com.example.mad_assignment2.screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_assignment2.MainActivity;
import com.example.mad_assignment2.R;
import com.example.mad_assignment2.data.CustomAdapter;
import com.example.mad_assignment2.data.EventDBHelper;
import com.example.mad_assignment2.data.VendorDBHelper;
import com.example.mad_assignment2.models.Event;
import com.example.mad_assignment2.models.Vendor;

import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;

public class EventDetailScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    Button backButton;

    VendorDBHelper vendorDBHelper;

    EventDBHelper eventDBHelper;
    ArrayList<String> name, description, category, imageUrl, rating, boothLocation;

    CustomAdapter customAdapter;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details_screen);

        recyclerView = findViewById(R.id.recyclerView);
        vendorDBHelper = new VendorDBHelper(EventDetailScreen.this);
        eventDBHelper = new EventDBHelper(EventDetailScreen.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        imageUrl = new ArrayList<>();
        rating = new ArrayList<>();
        boothLocation = new ArrayList<>();

        try {
            storeVendorDataInArrays();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        customAdapter = new CustomAdapter(EventDetailScreen.this, name, description, category, imageUrl, rating, boothLocation);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(EventDetailScreen.this));

        ImageButton backImageButton = findViewById(R.id.backImageButton);
        backImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the target activity you want to navigate to
                finish();
            }
        });

        ImageButton previewImageButton = findViewById(R.id.previewImageButton);
        previewImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the target activity you want to navigate to
                Intent intent = new Intent(EventDetailScreen.this, EventPreviewScreen.class);
                startActivity(intent);
            }
        });

    }

    void storeVendorDataInArrays() throws ParseException {

        Intent intent = getIntent();
        int event_id = intent.getIntExtra("event_id", -1);


        Event event = eventDBHelper.getEventFromId(event_id);
        ArrayList<String> vendorIdForThatList = event.getVendorIdList();
        for (String vendorId : vendorIdForThatList) {
            Vendor vendor = vendorDBHelper.getVendorByName(vendorId);
            name.add(vendor.getName());
            description.add(vendor.getDescription());
            category.add(vendor.getCategory());
            imageUrl.add(vendor.getImageUrl());
            rating.add(String.valueOf(vendor.getRating()));
            boothLocation.add(String.valueOf(vendor.getBoothLocation()));
        }


    }
}






