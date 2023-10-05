package com.example.mad_assignment2.models;

public class Event {
    String title;
    String description;
    String organizer;
    String backgroundLogoUrl;
    String layoutUrl;
    String date;
    String time;


    public Event(String t, String d, String o, String b, String l, String da, String tim) {
        this.title = t;
        this.description = d;
        this.organizer = o;
        this.backgroundLogoUrl = b;
        this.layoutUrl = l;
        this.date = d;
        this.time = tim;
    }
}
