package com.example.androidfinalproject.Class;

/**
 * @author 18301092-陈佳林
 * 选择的习惯的范围实体类
 */
public class HabitChoice {

    //习惯编号
    private int choiceNum = 0;
    //习惯名称
    private String choiceName = "";
    //习惯描述
    private String choiceDescription = "";

    public HabitChoice() {}

    public HabitChoice(int choiceNum, String choiceName, String choiceDescription) {
        this.choiceNum = choiceNum;
        this.choiceName = choiceName;
        this.choiceDescription = choiceDescription;
    }

    @Override
    public String toString() {
        return "HabitChoice{" +
                "choiceNum=" + choiceNum +
                ", choiceName='" + choiceName + '\'' +
                ", choiceDescription='" + choiceDescription + '\'' +
                '}';
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public void setChoiceNum(int choiceNum) {
        this.choiceNum = choiceNum;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public String getChoiceDescription() {
        return choiceDescription;
    }

    public void setChoiceDescription(String choiceDescription) {
        this.choiceDescription = choiceDescription;
    }

}
