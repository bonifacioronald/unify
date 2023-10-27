package com.example.mad_assignment2.data;

import com.example.mad_assignment2.models.Event;
import com.example.mad_assignment2.models.Vendor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class VendorInitData {

    public static ArrayList<Vendor> initializeVendorToArrayList() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ArrayList<Vendor> initialVendorList = new ArrayList<>();

        Vendor basketballClub = new Vendor("1",
                "Taylor's Basketball Club",
                "tbc@gmail.com",
                "tbc",
                "Taylor's Basketball Club welcomes all basketball enthusiasts to join us for exciting games and skill development.",
                "Clubs & Society",
                "https://static.toiimg.com/thumb/msid-70661134,width-1280,resizemode-4/70661134.jpg",
                4,
                1);

        Vendor volleyballClub = new Vendor("2",
                "Taylor's Volleyball Club",
                "tvc@gmail.com",
                "tvc",
                "Join Taylor's Volleyball Club to spike your way to victory and enjoy the thrill of the game.",
                "Clubs & Society",
                "https://medias.paris2024.org/uploads/2023/03/GettyImages-591969630-min-scaled.jpg?x-oss-process=image/resize,w_2560,h_1706,m_lfit/format,jpeg",
                4.5,
                2);

        Vendor cookingClub = new Vendor("3",
                "Taylor's Cooking Club",
                "tcc@gmail.com",
                "tcc",
                "Explore the world of culinary arts with Taylor's Cooking Club and master the art of cooking.",
                "Clubs & Society",
                "https://media-cldnry.s-nbcnews.com/image/upload/newscms/2019_41/3044956/191009-cooking-vegetables-al-1422.jpg",
                4.2,
                3);

        Vendor kfc = new Vendor("4",
                "KFC",
                "kfc@gmail.com",
                "kfc",
                "Enjoy the world-famous fried chicken and delicious sides at KFC.",
                "Food & Beverage",
                "",
                4.7,
                4);

        Vendor mcdonalds = new Vendor("5",
                "McDonald's",
                "mcdonalds@gmail.com",
                "mcdonalds",
                "Savor iconic burgers, fries, and more at McDonald's.",
                "Food & Beverage",
                "",
                4.5,
                5);

        Vendor starbucks = new Vendor("6",
                "Starbucks",
                "starbucks@gmail.com",
                "starbucks",
                "Indulge in premium coffee and beverages at Starbucks.",
                "Food & Beverage",
                "",
                4.8,
                6);

        Vendor nasiLemakDelights = new Vendor("7",
                "Nasi Lemak Delights",
                "nasilemak@gmail.com",
                "nasilemak123",
                "Experience the rich flavors of Malaysia with our delicious Nasi Lemak.",
                "Food & Beverage",
                "https://www.yummytummyaarthi.com/wp-content/uploads/2023/03/3f0d98a9-c59f-4dac-8071-4087d82aa365-scaled.jpeg", // You can replace with the actual image URL
                4.6,
                7);

        Vendor rotiCanaiCorner = new Vendor("8",
                "Roti Canai Corner",
                "roticanai@gmail.com",
                "roticanai456",
                "Savor crispy and fluffy Roti Canai with a variety of curries.",
                "Food & Beverage",
                "https://www.kuali.com/wp-content/uploads/2015/05/Roti-canai.jpg", // You can replace with the actual image URL
                4.7,
                8);

        Vendor satayParadise = new Vendor("9",
                "Satay Paradise",
                "satay@gmail.com",
                "satay789",
                "Enjoy succulent and grilled Satay skewers with peanut sauce.",
                "Food & Beverage",
                "https://media-cdn2.greatbritishchefs.com/media/p5abv3mz/img82070.whqc_1426x713q80.jpg", // You can replace with the actual image URL
                4.5,
                9);

        Vendor laksaHaven = new Vendor("10",
                "Laksa Haven",
                "laksa@gmail.com",
                "laksa101",
                "Taste the spicy and aromatic flavors of Laksa, a Malaysian favorite.",
                "Food & Beverage",
                "https://rasamalaysia.com/wp-content/uploads/2011/07/curry-laksa-thumb.jpg", // You can replace with the actual image URL
                4.4,
                10);

        Vendor hainaneseChickenRice = new Vendor("11",
                "Hainanese Chicken Rice Delights",
                "chickenrice@gmail.com",
                "chickenrice2022",
                "Satisfy your taste buds with tender Hainanese Chicken Rice.",
                "Food & Beverage",
                "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/154660.jpg", // You can replace with the actual image URL
                4.5,
                11);

        Vendor cendolOasis = new Vendor("12",
                "Cendol Oasis",
                "cendol@gmail.com",
                "cendol567",
                "Cool down with refreshing Cendol topped with palm sugar and coconut milk.",
                "Food & Beverage",
                "https://sm.mashable.com/mashable_sea/photo/default/cendol-melaka-food-blog-1_64sj.jpg", // You can replace with the actual image URL
                4.3,
                12);

        initialVendorList.add(basketballClub);
        initialVendorList.add(volleyballClub);
        initialVendorList.add(cookingClub);
        initialVendorList.add(kfc);
        initialVendorList.add(mcdonalds);
        initialVendorList.add(starbucks);
        initialVendorList.add(nasiLemakDelights);
        initialVendorList.add(rotiCanaiCorner);
        initialVendorList.add(satayParadise);
        initialVendorList.add(laksaHaven);
        initialVendorList.add(hainaneseChickenRice);
        initialVendorList.add(cendolOasis);


        return initialVendorList;
    }
}