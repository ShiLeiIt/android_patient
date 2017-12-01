package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShiLei on 2017/12/1.
 */

public class ScaleDetailBean  implements Serializable{

    /**
     * paperData : null
     * paperUserID : 359
     * userID : 180
     * paperID : 10d72feeb47d4c9bb6403dd0ee4146ca
     * questionList : []
     * 量表详情
     */

    private Object paperData;
    private String paperUserID;
    private String userID;
    private String paperID;
    private List<ScaleTitleBean> questionList;

    public Object getPaperData() {
        return paperData;
    }

    public void setPaperData(Object paperData) {
        this.paperData = paperData;
    }

    public String getPaperUserID() {
        return paperUserID;
    }

    public void setPaperUserID(String paperUserID) {
        this.paperUserID = paperUserID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPaperID() {
        return paperID;
    }

    public void setPaperID(String paperID) {
        this.paperID = paperID;
    }

    public List<ScaleTitleBean> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<ScaleTitleBean> questionList) {
        this.questionList = questionList;
    }
}
