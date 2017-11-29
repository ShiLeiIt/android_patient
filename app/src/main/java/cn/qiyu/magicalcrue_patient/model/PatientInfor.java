package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by ShiLei on 2017/11/27.
 * 患者基本信息
 */

public class PatientInfor implements Serializable {


    /**
     * birthday : 2017-11-15
     * UserMobile : 13046666512
     * nativeName : 内蒙古自治区-巴彦淖尔市-乌拉特前旗
     * follow_doctor : 5b9a9d6a0f4540ed8fd0734820fa82ef
     * user_name : 张龙
     * modify_time : 2017-11-27 14:56:59
     * native_place_name : 内蒙古自治区,巴彦淖尔市,乌拉特前旗
     * uuid : 6d64ff4f7f8643b0bac27582a3ce7fc7
     * relationshipName : 母亲
     * STATUS : 0
     * IDcardNo : 420923199109116254
     * sexName : 男
     * id : 672
     * disease_name : 肝癌
     * relationship : mother
     * firstVisitTime : 2012-11-16
     * native_place_cd : 150000,150800,150804
     * create_time : 2017-11-17 00:43:08
     * sex : 0
     * mobile : 13046666512
     * is_delete : 0
     * disease_id : 64a239f51c4c11e7b8ea00163e12644c
     * name : 张龙Ziv
     * attending_doctor : 张龙
     * marriageName : 保密
     */

    private String birthday;
    private String UserMobile;
    private String nativeName;
    private String follow_doctor;
    private String user_name;
    private String modify_time;
    private String native_place_name;
    private String uuid;
    private String relationshipName;
    private int STATUS;
    private String IDcardNo;
    private String sexName;
    private int id;
    private String disease_name;
    private String relationship;
    private String firstVisitTime;
    private String native_place_cd;
    private String create_time;
    private String sex;
    private String mobile;
    private int is_delete;
    private String disease_id;
    private String name;
    private String attending_doctor;
    private String marriageName;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserMobile() {
        return UserMobile;
    }

    public void setUserMobile(String UserMobile) {
        this.UserMobile = UserMobile;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getFollow_doctor() {
        return follow_doctor;
    }

    public void setFollow_doctor(String follow_doctor) {
        this.follow_doctor = follow_doctor;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getNative_place_name() {
        return native_place_name;
    }

    public void setNative_place_name(String native_place_name) {
        this.native_place_name = native_place_name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getIDcardNo() {
        return IDcardNo;
    }

    public void setIDcardNo(String IDcardNo) {
        this.IDcardNo = IDcardNo;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(String firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public String getNative_place_cd() {
        return native_place_cd;
    }

    public void setNative_place_cd(String native_place_cd) {
        this.native_place_cd = native_place_cd;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(String disease_id) {
        this.disease_id = disease_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttending_doctor() {
        return attending_doctor;
    }

    public void setAttending_doctor(String attending_doctor) {
        this.attending_doctor = attending_doctor;
    }

    public String getMarriageName() {
        return marriageName;
    }

    public void setMarriageName(String marriageName) {
        this.marriageName = marriageName;
    }
}
