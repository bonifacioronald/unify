package com.example.mad_assignment2.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mad_assignment2.R;
import com.example.mad_assignment2.data.EventDBHelper;

public class VendorBookingCalendarScreen extends AppCompatActivity {

    Button cnsDate16Button, cnsDate17Button, cnsDate18Button, cnsDate19Button, cnsDate20Button, cnsDate21Button, cnsDate22Button, cnsDate23Button;
    Button tffDate4Button, tffDate5Button, tffDate6Button, tffDate7Button, tffDate8Button;
    ImageButton backButton;
    EventDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_booking_calendar_screen);

        cnsDate16Button = findViewById(R.id.cnsDate16Button);
        cnsDate17Button = findViewById(R.id.cnsDate17Button);
        cnsDate18Button = findViewById(R.id.cnsDate18Button);
        cnsDate19Button = findViewById(R.id.cnsDate19Button);
        cnsDate20Button = findViewById(R.id.cnsDate20Button);
        cnsDate21Button = findViewById(R.id.cnsDate21Button);
        cnsDate22Button = findViewById(R.id.cnsDate22Button);
        cnsDate23Button = findViewById(R.id.cnsDate23Button);

        tffDate4Button = findViewById(R.id.tffDate4Button);
        tffDate5Button = findViewById(R.id.tffDate5Button);
        tffDate6Button = findViewById(R.id.tffDate6Button);
        tffDate7Button = findViewById(R.id.tffDate7Button);
        tffDate8Button = findViewById(R.id.tffDate8Button);

        ImageButton backButton = findViewById(R.id.backButton);


        cnsDate16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addVendorToEvent(1, 1);
            }
        });
    }


}