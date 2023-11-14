package com.example.mad_assignment2.screens;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.mad_assignment2.R;
import com.example.mad_assignment2.data.VendorDBHelper;
import com.example.mad_assignment2.models.Vendor;

public class VendorDetailScreen extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView averageRatingView;
    public int buttonId;
    private VendorDBHelper vendorDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_detail);

        vendorDBHelper = new VendorDBHelper(this);
        
        String vendorName = getIntent().getStringExtra("CLICKED_VENDOR_NAME");
        Log.d("CHECKING FOR BUTTON", vendorName);
    
        ratingBar = findViewById(R.id.ratingBar);
        averageRatingView = findViewById(R.id.averageRatingTextView);

        setDetailContent(vendorName);

        // Set the RatingBar change listener
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    // Update rating in database
                    Vendor vendor = vendorDBHelper.getVendorByName(vendorName);
                    if (vendor != null) {
                        vendor.setRating(rating);
                        vendorDBHelper.updateVendorRating(vendor);

                        // Update the average rating view
                        averageRatingView.setText(String.format("Average Rating: %.2f", rating));
                    }
                }
            }
        });

        ImageButton backButton = findViewById(R.id.backButton01);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setDetailContent(String vendorName) {

        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        Vendor vendor = vendorDBHelper.getVendorByName(vendorName);

        if (vendor != null) {
            String boothDirectoryResourceName = vendor.getBoothDirectory();
            String imageUrlResourceName = vendor.getImageUrl();
            Log.d("VendorDetailScreen", "Booth Directory Resource Name: " + boothDirectoryResourceName);
            Log.d("VendorDetailScreen", "Image URL Resource Name: " + imageUrlResourceName);

            int boothDirectoryResourceId = getResources().getIdentifier(boothDirectoryResourceName, "drawable", getPackageName());
            int imageUrlResourceId = getResources().getIdentifier(imageUrlResourceName, "drawable", getPackageName());
            Log.d("VendorDetailScreen", "Booth Directory Resource ID: " + boothDirectoryResourceId);
            Log.d("VendorDetailScreen", "Image URL Resource ID: " + imageUrlResourceId);

            Glide.with(this)
                    .load(getResources().getIdentifier(vendor.getBoothDirectory(), "drawable", getPackageName()))
                    .placeholder(R.drawable.dic01)
                    .error(R.drawable.taylors_logo)
                    .into(imageView1);

            Glide.with(this)
                    .load(vendor.getImageUrl()) // Provide the URL for the image
                    .placeholder(R.drawable.dic01) // Optional: Placeholder image while loading
                    .error(R.drawable.taylors_logo) // Optional: Image to display in case of error
                    .into(imageView2);

            titleTextView.setText(vendor.getName());
            descriptionTextView.setText(vendor.getDescription());



            // Set rating and average rating view
//          ratingBar.setRating((float) vendor.getRating());
            averageRatingView.setText(String.format("Average Rating: %.2f", vendor.getRating()));
        }
    }

    @Override
    protected void onDestroy() {
        vendorDBHelper.close();
        super.onDestroy();
    }
}
