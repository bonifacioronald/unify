package com.example.mad_assignment2.data;

import com.example.mad_assignment2.models.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

public class EventInitData {

    public static ArrayList<Event> initializeEventToArrayList() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ArrayList<Event> initialEventList = new ArrayList<>();

        Event cnsFestival = new Event(1,
                "Club & Society Festival",
                "Browse through and learn more about Taylor’s University’s diverse clubs and societies. Free of charge!",
                "Orientation Leaders",
                "https://selangor.travel/wp-content/uploads/2019/09/Taylors_College_Lakeside_Tourism_Selangor.jpg",
                new Date(String.valueOf(dateFormat.parse("16-11-2023"))),
                new Date(String.valueOf(dateFormat.parse("23-11-2023"))),
                "8:00 AM - 5:00 PM",
                new ArrayList<String>());

        ArrayList<String> cnsVendorIdList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            cnsVendorIdList.add(String.valueOf(i));
        }

        cnsFestival.setVendorIdList(cnsVendorIdList);

        Event traditionalFoodFestival = new Event(1,
                "Traditional Food Festival",
                "Taylor's University celebrates its diverse culture with a traditional food festival featuring a tantalizing array of authentic dishes from around the world",
                "TU Student Council",
                "https://travelfoodatlas.com/wp-content/uploads/2021/11/malaysian-food.jpg.webp",
                new Date(String.valueOf(dateFormat.parse("4-12-2023"))),
                new Date(String.valueOf(dateFormat.parse("8-12-2023"))),
                "8:00 AM - 5:00 PM",
                new ArrayList<>());

        ArrayList<String> traditionalFoodVendorIdList = new ArrayList<>();
        for (int i = 7; i <= 12; i++) {
            traditionalFoodVendorIdList.add(String.valueOf(i));
        }

        traditionalFoodFestival.setVendorIdList(traditionalFoodVendorIdList);

        initialEventList.add(cnsFestival);
        initialEventList.add(traditionalFoodFestival);
        return  initialEventList;
    }
}
