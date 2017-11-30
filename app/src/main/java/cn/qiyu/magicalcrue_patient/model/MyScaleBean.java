package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/30.
 * 量表信息
 */

public class MyScaleBean {


    /**
     * create_time : 2017-09-12 09:40:39
     * remark : 公有量表
     * paperUserID : 47
     * paperID : 5606d59f8fec4e24804ccce5fbd1559b
     * paperTitle : 欧洲癌症研究与治疗组织生命质量测定量表
     * status : 0
     * doctor_read : 1
     */

    private String create_time;
    private String remark;
    private int paperUserID;
    private String paperID;
    private String paperTitle;
    private int status;
    private int doctor_read;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPaperUserID() {
        return paperUserID;
    }

    public void setPaperUserID(int paperUserID) {
        this.paperUserID = paperUserID;
    }

    public String getPaperID() {
        return paperID;
    }

    public void setPaperID(String paperID) {
        this.paperID = paperID;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDoctor_read() {
        return doctor_read;
    }

    public void setDoctor_read(int doctor_read) {
        this.doctor_read = doctor_read;
    }
}
