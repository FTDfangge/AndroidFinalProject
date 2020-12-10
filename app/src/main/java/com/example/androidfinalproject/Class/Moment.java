package com.example.androidfinalproject.Class;

public class Moment {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
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

    private int userIcon;
    private String punchTime;
    private String punchDescription;

    public int getPunchImage() {
        return punchImage;
    }

    public void setPunchImage(int punchImage) {
        this.punchImage = punchImage;
    }

    private int punchImage;

    public Moment(){

    }


}
