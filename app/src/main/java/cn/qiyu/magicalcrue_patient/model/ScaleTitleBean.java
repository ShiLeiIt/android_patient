package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShiLei on 2017/12/1.
 */

public class ScaleTitleBean  implements Serializable{


    /**
     * pkID : b2d04cdf147c41d9903f2b98b8f22154
     * questionID : ce21132dd5b44acc837a8e5472653ed6
     * create_time : 2017-09-11 16:20:22
     * answerOptionIOS : []
     * modify_user : 1
     * modify_time : 2017-09-11 16:20:22
     * answerResult :
     * sort : 0
     * content : 数字评分法（VAS）是将疼痛的程度用0到10 共11个数字表示，0表示无痛，3分以下有轻微的疼痛，4-6分，患者疼痛并影响睡眠，尚能忍受，7-10代表最痛，请根据自身疼痛程度在这11个数字中挑选一个数字代表疼痛程度。
     * is_delete : 0
     * Name : 单选
     * optionsList : []
     * create_user : 1
     * questionType : radio
     * answerOption : []
     * paperID : 10d72feeb47d4c9bb6403dd0ee4146ca
     * status : 0
     */

    private String pkID;
    private String questionID;
    private String create_time;
    private String modify_user;
    private String modify_time;
    private String answerResult;
    private int sort;
    private String content;
    private int is_delete;
    private String Name;
    private String create_user;
    private String questionType;
    private String answerOption;
    private String paperID;
    private int status;
    private List<String> answerOptionIOS;
    private List<ScaleSelectBean> optionsList;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPkID() {
        return pkID;
    }

    public void setPkID(String pkID) {
        this.pkID = pkID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(String answerResult) {
        this.answerResult = answerResult;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public String getPaperID() {
        return paperID;
    }

    public void setPaperID(String paperID) {
        this.paperID = paperID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getAnswerOptionIOS() {
        return answerOptionIOS;
    }

    public void setAnswerOptionIOS(List<String> answerOptionIOS) {
        this.answerOptionIOS = answerOptionIOS;
    }

    public List<ScaleSelectBean> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<ScaleSelectBean> optionsList) {
        this.optionsList = optionsList;
    }
}
