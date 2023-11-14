package com.example.mad_assignment2.screens;

import static android.text.format.DateUtils.formatDateRange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

import com.example.mad_assignment2.R;
import com.example.mad_assignment2.data.EventDBHelper;
import com.example.mad_assignment2.data.VendorDBHelper;
import com.example.mad_assignment2.models.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EventPreviewScreen extends AppCompatActivity {

    private Button backButton, eventDetailButton;
    private TextView eventTitleText, eventDescriptionText,eventDateText,eventTimeText;
    private EventDBHelper eventDBHelper;
    private View event_preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_preview_screen);

        backButton = findViewById(R.id.backButton);
        eventTitleText = findViewById(R.id.eventTitleText);
        eventDescriptionText = findViewById(R.id.eventDescriptionText);
        eventDateText = findViewById(R.id.eventDateText);
        eventTimeText = findViewById(R.id.eventTimeText);
        eventDetailButton = findViewById(R.id.eventDetailButton);
        eventDBHelper = new EventDBHelper(this);
        event_preview = findViewById(R.id.event_preview);





        Intent intent = getIntent();
        int event_id = intent.getIntExtra("event_id",-1);
        eventDBHelper.logEventData();
        System.out.println("" + event_id);

        if (event_id > 0) {
            Event event = null;
            try {
                event = eventDBHelper.getEventFromId(event_id);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        eventTitleText.setText(event.getTitle());
        eventTimeText.setText(event.getTime());
        eventDescriptionText.setText(event.getDescription());
        eventDateText.setText(formatDateRange(event.getStartDate(), event.getEndDate()));
        eventTimeText.setText(eventDBHelper.getEventTime(event_id));

        //change background
        String bg_drawable = event.getBackgroundLogoUrl();
        int drawable_id = getResources().getIdentifier(bg_drawable,"drawable",getPackageName());
        Drawable backgroundImg = getResources().getDrawable(drawable_id);
        event_preview.setBackground(backgroundImg);


        System.out.println(eventDescriptionText.getText());
        System.out.println(eventDBHelper.getEventDescription(event_id));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        eventDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                int event_id = intent.getIntExtra("event_id",-1);
                eventDBHelper.logEventData();
                System.out.println("" + event_id);

                intent = new Intent(EventPreviewScreen.this, EventDetailScreen.class);
                intent.putExtra("event_id",event_id);

                startActivity(intent);
            }
        });
    }
}

    private String formatDateRange(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthYearFormat = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        String formattedStartDate = dateFormat.format(startDate);
        String formattedEndDate = dateFormat.format(endDate);
        String formattedMonthYear = monthYearFormat.format(startDate);
        return formattedStartDate + " - " + formattedEndDate + " " + formattedMonthYear;
    }
}
