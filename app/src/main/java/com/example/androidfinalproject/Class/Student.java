package com.example.androidfinalproject.Class;

/**
 * @author 18301092-陈佳林
 * 学生用户的实体类
 */
public class Student {
    //用户学号
    private String studentNumber = "";
    //用户姓名
    private String studentName = "";
    //用户昵称
    private String nickName = "";
    //用户邮箱
    private String mailAddress = "";
    //性别，1表示为女生,2表示为男生
    private int studentSex = 0;
    //用户密码
    private String studentPassword = "";
    //用户打卡圈的背景图片
    private String backImage = "";
    //用户头像
    private String studentPortrait = "";
    //用户选择养成的习惯
    private int choiceNum = 0;

    public Student() {    }

    public Student(String studentNumber, String studentName, String nickName, String mailAddress, int studentSex, String studentPassword, String backImage, String studentPortrait, int choiceNum) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.nickName = nickName;
        this.mailAddress = mailAddress;
        this.studentSex = studentSex;
        this.studentPassword = studentPassword;
        this.backImage = backImage;
        this.studentPortrait = studentPortrait;
        this.choiceNum = choiceNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", studentSex=" + studentSex +
                ", studentPassword='" + studentPassword + '\'' +
                ", backImage='" + backImage + '\'' +
                ", studentPortrait='" + studentPortrait + '\'' +
                '}';
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getStudentPortrait() {
        return studentPortrait;
    }

    public void setStudentPortrait(String studentPortrait) {
        this.studentPortrait = studentPortrait;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public void setChoiceNum(int choiceNum) {
        this.choiceNum = choiceNum;
    }
}
