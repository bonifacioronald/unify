package com.example.mad_assignment2.models;

public class Vendor {
    String id;
    String name;
    String email;
    String password;
    String description;
    String category;
    String logoUrl;

    public Vendor(String i, String n, String e, String p, String d, String c, String l) {
        this.id = i;
        this.name = n;
        this.email = e;
        this.password = p;
        this.description = d;
        this.category = c;
        this.logoUrl = l;
    }
}
