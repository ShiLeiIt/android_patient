package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/20.
 * 用户信息保存Bean
 */

public class UserInforEdt {
    private String id;
    private String photoPath;
    private String user_name;
    private String birthday;
    private String sex;
    private String native_place_cd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNative_place_cd() {
        return native_place_cd;
    }

    public void setNative_place_cd(String native_place_cd) {
        this.native_place_cd = native_place_cd;
    }
}
