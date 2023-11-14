package com.example.mad_assignment2.data;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mad_assignment2.R;
import com.example.mad_assignment2.screens.VendorDetailScreen;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> name, description, category, imageUrl, rating, boothLocation;

    public CustomAdapter(Context context,
                         ArrayList<String> name,
                         ArrayList<String> description,
                         ArrayList<String> category,
                         ArrayList<String> imageUrl,
                         ArrayList<String> rating,
                         ArrayList<String> boothLocation) {
        this.context = context;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.boothLocation = boothLocation;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.vendor_name_txt.setText(name.get(position));
        holder.imageUrl_txt.setText(category.get(position));

        // Use Glide to load the image
        Glide.with(context)
                .load(imageUrl.get(position)) // Assuming imageUrl is a valid resource identifier
                .into(holder.imageView2);

        holder.eventDetailsLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, VendorDetailScreen.class);
            intent.putExtra("CLICKED_VENDOR_NAME", name.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView vendor_name_txt, imageUrl_txt;
        LinearLayout eventDetailsLayout;
        ImageView imageView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vendor_name_txt = itemView.findViewById(R.id.vendor_name_txt);
            imageUrl_txt = itemView.findViewById(R.id.imageUrl_txt);
            eventDetailsLayout = itemView.findViewById(R.id.eventDetailsLayout);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
