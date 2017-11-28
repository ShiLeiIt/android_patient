package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by ShiLei on 2017/11/27.
 * 患者基本信息
 */

public class PatientInfor implements Serializable {


    /**
     * birthday : 2017-10-14
     * UserMobile : 15925926265
     * nativeName : 吉林省-白山市-靖宇县
     * native_place_cd : 170000,170600,170604,
     * appFirstVisitTime : 2017-10-14
     * create_time : 2017-11-28 14:12:13
     * follow_doctor : 95bbb5cb43ec43b58b464e89be63a585
     * user_name : 实惠
     * sex : 0
     * modify_time : 2017-11-28 17:22:10
     * mobile : 12345688955
     * native_place_name : 吉林省,白山市,靖宇县
     * uuid : 29bbe608070b4fd5aadda5999d46f9d7
     * is_delete : 0
     * relationshipName : 自己
     * STATUS : 0
     * IDcardNo : 123466789885555555
     * sexName : 男
     * name : 石磊
     * attending_doctor :
     * id : 715
     * relationship : self
     * marriageName : 保密
     * firstVisitTime : 2017-10-14
     */

    private String birthday;
    private String UserMobile;
    private String nativeName;
    private String native_place_cd;
    private String appFirstVisitTime;
    private String create_time;
    private String follow_doctor;
    private String user_name;
    private String sex;
    private String modify_time;
    private String mobile;
    private String native_place_name;
    private String uuid;
    private int is_delete;
    private String relationshipName;
    private int STATUS;
    private String IDcardNo;
    private String sexName;
    private String name;
    private String attending_doctor;
    private int id;
    private String relationship;
    private String marriageName;
    private String firstVisitTime;

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

    public String getNative_place_cd() {
        return native_place_cd;
    }

    public void setNative_place_cd(String native_place_cd) {
        this.native_place_cd = native_place_cd;
    }

    public String getAppFirstVisitTime() {
        return appFirstVisitTime;
    }

    public void setAppFirstVisitTime(String appFirstVisitTime) {
        this.appFirstVisitTime = appFirstVisitTime;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getMarriageName() {
        return marriageName;
    }

    public void setMarriageName(String marriageName) {
        this.marriageName = marriageName;
    }

    public String getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(String firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }
}
