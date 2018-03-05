package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/7.
 * 消息界面,条目bean
 */

public class InforItemBean {

    /**
     * num : 0
     * title : 系统消息
     * type : 2
     * content : 医生团队给您发了一份量表，请尽快填写。
     * content_type: 1
     */

    private int num;
    private String title;
    private int type;
    private int content_type;
    private String content;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
