package com.example.mad_assignment2.screens;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mad_assignment2.R;
import com.example.mad_assignment2.data.EventDBHelper;

public class  CalendarVisitorScreen extends AppCompatActivity  {

    Button[] cnsDateButtons = new Button[8];
    Button[] tffDateButtons = new Button[5];
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_visitor_screen);

        initDateButtons();
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View.OnClickListener dateButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eventId = getEventIdFromButtonId(view.getId());
                if (eventId > 0) {
                    Intent toEventPreview = new Intent(CalendarVisitorScreen.this, EventPreviewScreen.class);
                    toEventPreview.putExtra("event_id", eventId);
                    startActivity(toEventPreview);
                }
            }
        };

        // Set the OnClickListener for all date buttons
        for (Button button : cnsDateButtons) {
            button.setOnClickListener(dateButtonClickListener);
        }

        for (Button button : tffDateButtons) {
            button.setOnClickListener(dateButtonClickListener);
        }
    }
    private void initDateButtons() {
        for (int i = 0; i < 8; i++) {
            int buttonId = getResources().getIdentifier("cnsDate" + (i + 16) + "Button", "id", getPackageName());
            cnsDateButtons[i] = findViewById(buttonId);
        }

        for (int i = 0; i < 5; i++) {
            int buttonId = getResources().getIdentifier("tffDate" + (i + 4) + "Button", "id", getPackageName());
            tffDateButtons[i] = findViewById(buttonId);
        }
    }
    private int getEventIdFromButtonId(int buttonId) {
        if (buttonId == R.id.cnsDate16Button || buttonId == R.id.cnsDate17Button || buttonId == R.id.cnsDate18Button ||
                buttonId == R.id.cnsDate19Button || buttonId == R.id.cnsDate20Button || buttonId == R.id.cnsDate21Button ||
                buttonId == R.id.cnsDate22Button || buttonId == R.id.cnsDate23Button) {
            return 1;
        } else if (buttonId == R.id.tffDate4Button || buttonId == R.id.tffDate5Button || buttonId == R.id.tffDate6Button ||
                buttonId == R.id.tffDate7Button || buttonId == R.id.tffDate8Button) {
            return 2;
        }
        return -1;
    }
}