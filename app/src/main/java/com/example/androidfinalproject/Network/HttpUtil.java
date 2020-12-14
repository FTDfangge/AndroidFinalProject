package com.example.androidfinalproject.Network;

import com.example.androidfinalproject.Class.CommentRecord;
import com.example.androidfinalproject.Class.LikeRecord;
import com.example.androidfinalproject.Class.PunchRecord;
import com.example.androidfinalproject.Class.Student;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author 18301092-陈佳林
 * 在与服务器要进行交互时使用的类
 */
public class HttpUtil {

    //注册的网址
    private static final String REGISTER_URL = "http://localhost:8080/register";
    //登录的网址
    private static final String LOGIN_URL = "http://localhost:8080/login";
    //请求发送验证码的网址
    private static final String VALID_URL = "http://localhost:8080/valid";
    //打卡的网址
    private static final String PUNCH_URL = "http://localhost:8080/punch";
    //自己打卡记录的网址
    private static final String PUNCH_INFO_URL = "http://localhost:8080/punchInfo";
    //圈子的网址
    private static final String CIRCLE_URL = "http://localhost:8080/circle";
    //评论的网址
    private static final String COMMENT_URL = "http://localhost:8080/comment";
    //点赞的网址
    private static final String LIKE_URL = "http://localhost:8080/like";
    //修改注册信息的网址
    private static final String MODIFY_STUDENT_INFO_URL = "http://localhost:8080/modifyStudentInfo";
    //修改密码的网址
    private static final String MODIFY_STUDENT_PASSWORD_URL = "http://localhost:8080/modifyPassword";

    /**
     * 学生注册的时候调用的方法
     * @param student 已经确认合法的学生实例
     * @param callback 服务器返回后
     */
    public static void sendRegister(Student student, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("studentNumber", student.getStudentNumber())
                .add("studentName", student.getStudentName())
                .add("nickName", student.getNickName())
                .add("mailAddress", student.getMailAddress())
                .add("studentSex", student.getStudentSex() + "")
                .add("studentPassword", student.getStudentPassword())
                .add("backImage", student.getBackImage())
                .add("studentPortrait", student.getStudentPortrait())
                .add("choiceNum", student.getChoiceNum() + "")
                .build();
        Request request  = new Request.Builder()
                .url(REGISTER_URL)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 学生登录的时候调用的方法
     * @param studentNumber 学生学号
     * @param studentPassword 学生密码
     * @param callback 服务器返回后
     */
    public static void sendLogin(String studentNumber, String studentPassword, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("studentNumber", studentNumber)
                .add("studentPassword", studentPassword)
                .build();
        Request request  = new Request.Builder()
                .url(LOGIN_URL)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 用户打卡的时候调用
     * @param punchRecord 打卡记录
     * @param callback 服务器返回后
     */
    public static void sendPunch(PunchRecord punchRecord, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("studentNum", punchRecord.getStudentNumber())
                .add("punchText", punchRecord.getPunchText())
                .add("punchTime", punchRecord.getPunchTime())
                .add("punchPic", punchRecord.getPunchPic())
                .build();
        Request request  = new Request.Builder()
                .url(PUNCH_URL)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 用户想要打开圈子界面的时候调用
     * @param callback 服务器返回后
     */
    public static void sendCircle(okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request  = new Request.Builder()
                .url(CIRCLE_URL)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 当某个用户评论某条打卡记录的时候
     * @param commentRecord 评论界面
     * @param callback 服务器返回后
     */
    public static void sendComment(CommentRecord commentRecord, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("fromStudent", commentRecord.getFromStudent())
                .add("commentText", commentRecord.getCommentText())
                .add("punchRecordNum", commentRecord.getPunchRecordNum() + "")
                .build();
        Request request  = new Request.Builder()
                .url(COMMENT_URL)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 当某用户点赞某个打卡记录的时候
     * @param likeRecord 打卡记录
     * @param flag 表示是要取消点赞还是点赞，1表示点赞，2表示取消
     * @param callback  服务器返回后
     */
    public static void sendLike(LikeRecord likeRecord, int flag, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("fromStudent", likeRecord.getFromStudent())
                .add("punchRecordNum", likeRecord.getPunchRecordNum() + "")
                .add("flag", flag + "")
                .build();
        Request request  = new Request.Builder()
                .url(LIKE_URL)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
