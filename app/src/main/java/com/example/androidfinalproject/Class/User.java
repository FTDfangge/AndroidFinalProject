package com.example.androidfinalproject.Class;

import android.media.Image;

public class User {

    private String it1,it2,it3;
    private int imageID,imageID2;

    public User(String s, String it1, String it2, int imageID, int imageID2){
        this.it1 = it1;
        this.it2 = it2;
        this.it3 = it3;
        this.imageID = imageID;
        this.imageID2 = imageID2;
    }



    public String getName(){
        return it1;
    }

    public String getTime(){
        return it2;
    }

    public String getText(){
        return it3;
    }

    public int getImageID(){
        return imageID;
    }

    public int getImageID2(){
        return imageID2;
    }

}

