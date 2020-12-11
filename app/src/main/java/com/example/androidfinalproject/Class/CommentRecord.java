package com.example.androidfinalproject.Class;

/**
 * @author 18301092-陈佳林
 * 评论的实体类
 */
public class CommentRecord {

    //评论编号
    private int commentNum = 0;
    //评论的学生学号
    private String fromStudent = "";
    //评论的文字内容
    private String commentText = "";
    //打卡记录编号
    private int punchRecordNum = 0;

    public CommentRecord() {    }

    public CommentRecord(int commentNum, String fromStudent, String commentText, int punchRecordNum) {
        this.commentNum = commentNum;
        this.fromStudent = fromStudent;
        this.commentText = commentText;
        this.punchRecordNum = punchRecordNum;
    }

    @Override
    public String toString() {
        return "CommentRecord{" +
                "commentNum=" + commentNum +
                ", fromStudent='" + fromStudent + '\'' +
                ", commentText='" + commentText + '\'' +
                ", punchRecordNum=" + punchRecordNum +
                '}';
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getFromStudent() {
        return fromStudent;
    }

    public void setFromStudent(String fromStudent) {
        this.fromStudent = fromStudent;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getPunchRecordNum() {
        return punchRecordNum;
    }

    public void setPunchRecordNum(int punchRecordNum) {
        this.punchRecordNum = punchRecordNum;
    }
}
