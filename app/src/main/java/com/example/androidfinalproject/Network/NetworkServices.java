package com.example.androidfinalproject.Network;

import com.example.androidfinalproject.Class.Moment;
import com.example.androidfinalproject.Class.User;

import java.util.ArrayList;
import java.util.List;

public class NetworkServices {
    public static NetworkServices networkServices = new NetworkServices();

    public void login(String username, String password){
        //用username和password进行登录
    }

    public void signin(String username, String password){
        //用username和password进行注册
    }

    public void chooseHabit(int habitNumber){
        //用户选择习惯habitNumber
    }

    public void initUser(){
        //初始化本地登录的用户

    }

    public void punch(String username, String punchPic){
        //本地执行打卡，向服务器发送打卡的用户名，打卡图片
    }

    public List<Moment> getMomentList(){
        List<Moment> userList = new ArrayList<Moment>();
        //获取朋友圈列表
        return userList;
    }
}
