package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/23.
 * 患者信息保存Bean
 */

public class PatientInforBean {
    String userId;
    String name;
    String sex;
    String birthday;
    String idCardNO;
    String mobile;
    String native_place_cd;
    String attending_doctor;
    String firstVisitTime;
    String relationship;
    String disease_id;
    String appFirstVisitTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCardNO() {
        return idCardNO;
    }

    public void setIdCardNO(String idCardNO) {
        this.idCardNO = idCardNO;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNative_place_cd() {
        return native_place_cd;
    }

    public void setNative_place_cd(String native_place_cd) {
        this.native_place_cd = native_place_cd;
    }

    public String getAttending_doctor() {
        return attending_doctor;
    }

    public void setAttending_doctor(String attending_doctor) {
        this.attending_doctor = attending_doctor;
    }

    public String getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(String firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(String disease_id) {
        this.disease_id = disease_id;
    }

    public String getAppFirstVisitTime() {
        return appFirstVisitTime;
    }

    public void setAppFirstVisitTime(String appFirstVisitTime) {
        this.appFirstVisitTime = appFirstVisitTime;
    }
}
