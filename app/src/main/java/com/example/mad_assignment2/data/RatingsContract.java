package com.example.mad_assignment2.data;


import android.provider.BaseColumns;

public final class RatingsContract {
    private RatingsContract() {}

    public static class RatingEntry implements BaseColumns {
        public static final String TABLE_NAME = "ratings";
        public static final String COLUMN_RATING = "rating";
    }
}
