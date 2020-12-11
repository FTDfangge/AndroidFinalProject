package com.example.androidfinalproject.Class;

/**
 * @author 18301092-陈佳林
 * 点赞的实体类
 */
public class LikeRecord {

    //点赞编号
    private int likeNum = 0;
    //点赞的学生学号
    private String fromStudent = "";
    //点赞的打卡记录
    private int punchRecordNum = 0;

    public LikeRecord() {    }

    public LikeRecord(int likeNum, String fromStudent, int punchRecordNum) {
        this.likeNum = likeNum;
        this.fromStudent = fromStudent;
        this.punchRecordNum = punchRecordNum;
    }

    @Override
    public String toString() {
        return "LikeRecord{" +
                "likeNum=" + likeNum +
                ", fromStudent='" + fromStudent + '\'' +
                ", punchRecordNum=" + punchRecordNum +
                '}';
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getFromStudent() {
        return fromStudent;
    }

    public void setFromStudent(String fromStudent) {
        this.fromStudent = fromStudent;
    }

    public int getPunchRecordNum() {
        return punchRecordNum;
    }

    public void setPunchRecordNum(int punchRecordNum) {
        this.punchRecordNum = punchRecordNum;
    }
}
