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
     */

    private int num;
    private String title;
    private int type;
    private String content;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
