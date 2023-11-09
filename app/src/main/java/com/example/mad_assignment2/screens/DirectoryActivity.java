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
        button1.setOnClickListener(view -> openDetailActivity("dic01", "fandb_card1", "InsideScoop", "Inside Scoop is a popular ice " +
                "\n cream maker known for its " +
                "\n artisanal approach to crafting " +
                "\n delectable frozen treats."));

        ImageButton button2 = findViewById(R.id.imageButton2);
        button1.setOnClickListener(view -> openDetailActivity("dic02", "fandb_card2", "Domino's", "Domino's offers a wide variety " +
                "\n of delicious and freshly made " +
                "\n pizzas, sides, and desserts that " +
                "\n cater to different tastes."));

        ImageButton button3 = findViewById(R.id.imageButton3);
        button1.setOnClickListener(view -> openDetailActivity("dic03", "fandb_card3", "McDonald", "McDonald's serves a range \n" +
                "of iconic fast food options,\n" +
                "including burgers, fries, and \n" +
                "shakes, loved by millions worldwide."));

        ImageButton button4 = findViewById(R.id.imageButton4);
        button1.setOnClickListener(view -> openDetailActivity("dic04", "fandb_card4", "Chanel", "CHANEL is a renowned luxury\n" +
                "brand that offers a wide range\n" +
                "of fashion, fragrance, makeup, \n" +
                "skincare，fine jewelry, and watches."));

        ImageButton button5 = findViewById(R.id.imageButton5);
        button1.setOnClickListener(view -> openDetailActivity("dic05", "fandb_card5", "Balenciaga", "Balenciaga is renowned for its \n" +
                "innovative fusion of luxury and\n" +
                "streetwear. Their collections span \n" +
                "sneakers, handbags, and ready-to-wear."));

        ImageButton button6 = findViewById(R.id.imageButton6);
        button1.setOnClickListener(view -> openDetailActivity("dic06", "fandb_card6", "Uniqlo", "UNIQLO provides simple and casual \n" +
                "designed clothes with inexpensive \n" +
                "prices, yet great quality for men and\n" +
                "women of all ages."));

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

    private void openDetailActivity(String pictureName1,String pictureName2, String title, String description) {
        Intent intent = new Intent(DirectoryActivity.this, DirectoryDetailActivity.class);
        intent.putExtra("pictureName1", pictureName1);
        intent.putExtra("pictureName2", pictureName2);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        startActivity(intent);
    }
}
