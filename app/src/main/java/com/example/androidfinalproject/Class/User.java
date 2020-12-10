package com.example.androidfinalproject.Class;

import android.media.Image;

public class User {
    public static User localuser = new User();
    private String username,password;
    private String nickName,punchTime,punchDescription;
    private Habit myHabit = new Habit();
    private int numOfPunches = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime;
    }

    public String getPunchDescription() {
        return punchDescription;
    }

    public void setPunchDescription(String punchDescription) {
        this.punchDescription = punchDescription;
    }

    public int getIconImage() {
        return iconImage;
    }

    public void setIconImage(int iconImage) {
        this.iconImage = iconImage;
    }

    public int getPunchImage() {
        return punchImage;
    }

    public void setPunchImage(int punchImage) {
        this.punchImage = punchImage;
    }

    private int iconImage,punchImage;

    public User() {
        myHabit.setHabit("按时作息");
    }

    public User(String it1, String it2,String it3, int imageID, int imageID2){
        this.nickName = it1;
        this.punchTime = it2;
        this.punchDescription = it3;
        this.iconImage = imageID;
        this.punchImage = imageID2;
    }

    public Habit getMyHabit() {
        return myHabit;
    }

    public void setMyHabit(Habit myHabit) {
        this.myHabit = myHabit;
    }

    public int getNumOfPunches() {
        return numOfPunches;
    }

    public void setNumOfPunches(int numOfPunches) {
        this.numOfPunches = numOfPunches;
    }
}

