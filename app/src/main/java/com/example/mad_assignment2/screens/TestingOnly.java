package com.example.mad_assignment2.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_assignment2.R;

public class TestingOnly extends AppCompatActivity {

    TextView title_VendorName, title_description;

    String name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_VendorName = findViewById(R.id.VendorName);
        title_description = findViewById(R.id.description);
        getAndSetIntentData();
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("description")){
            name = getIntent().getStringExtra("name");
            description = getIntent().getStringExtra("description");

            title_VendorName.setText(name);
            title_description.setText(description);
        }
        else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }
}