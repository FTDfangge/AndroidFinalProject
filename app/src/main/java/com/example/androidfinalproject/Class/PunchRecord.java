package com.example.androidfinalproject.Class;

/**
 * @author 18301092-陈佳林
 * 打卡记录的实体类
 */
public class PunchRecord {

    //打卡记录编码
    private int punchRecordNum = 0;
    //打卡的学生学号
    private String studentNumber = "";
    //打卡的文字内容
    private String punchText = "";
    //打卡的时间
    private String punchTime = "";
    //打卡的配图
    private String punchPic = "";

    public PunchRecord() {    }

    public PunchRecord(int punchRecordNum, String studentNumber, String punchText, String punchTime, String punchPic) {
        this.punchRecordNum = punchRecordNum;
        this.studentNumber = studentNumber;
        this.punchText = punchText;
        this.punchTime = punchTime;
        this.punchPic = punchPic;
    }

    @Override
    public String toString() {
        return "PunchRecord{" +
                "punchRecordNum=" + punchRecordNum +
                ", studentNumber='" + studentNumber + '\'' +
                ", punchText='" + punchText + '\'' +
                ", punchTime='" + punchTime + '\'' +
                ", punchPic='" + punchPic + '\'' +
                '}';
    }

    public int getPunchRecordNum() {
        return punchRecordNum;
    }

    public void setPunchRecordNum(int punchRecordNum) {
        this.punchRecordNum = punchRecordNum;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPunchText() {
        return punchText;
    }

    public void setPunchText(String punchText) {
        this.punchText = punchText;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime;
    }

    public String getPunchPic() {
        return punchPic;
    }

    public void setPunchPic(String punchPic) {
        this.punchPic = punchPic;
    }
}
