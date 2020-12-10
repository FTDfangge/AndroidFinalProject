package com.example.androidfinalproject.Network;

import com.example.androidfinalproject.Class.Moment;
import com.example.androidfinalproject.Class.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Moment> getTestMomentList(){
        List<Moment> userList = new ArrayList<Moment>();
        //获取朋友圈列表
        Moment moment = new Moment();
        moment.setNickName("张三");
        moment.setPunchDescription("打卡描述");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        moment.setPunchTime(simpleDateFormat.format(date));
        userList.add(moment);

        Moment moment1 = new Moment();
        moment1.setNickName("李四");
        moment1.setPunchDescription("终于又进行了一次大咖");
        moment1.setPunchTime("2001年1月2日 18:59:00");
        userList.add(moment1);

        Moment moment2 = new Moment();
        moment2.setNickName("张三");
        moment2.setPunchDescription("打卡描述");
        moment2.setPunchTime(simpleDateFormat.format(date));
        userList.add(moment2);

        Moment moment3 = new Moment();
        moment3.setNickName("张三");
        moment3.setPunchDescription("打卡描述");
        moment3.setPunchTime(simpleDateFormat.format(date));
        userList.add(moment3);
        return userList;
    }
}
