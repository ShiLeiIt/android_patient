package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by ShiLei on 2018/1/23.
 */

public class VersionUpdateBean  implements Serializable{

    /**
     * app_platform : 1
     * app_channel : 0
     * app_name : 奇愈记患者Android
     * app_url : http://fir.im/m5kq
     * release_notes : 请升级到新版本以获得更好体验
     * version_number : 1.0-2018011120
     * id : 4
     * force_update : false
     * app_code : patient
     * release_title : 发现新版本
     */

    private int app_platform;
    private int app_channel;
    private String app_name;
    private String app_url;
    private String release_notes;
    private String version_number;
    private int id;
    private boolean force_update;
    private String app_code;
    private String release_title;

    public int getApp_platform() {
        return app_platform;
    }

    public void setApp_platform(int app_platform) {
        this.app_platform = app_platform;
    }

    public int getApp_channel() {
        return app_channel;
    }

    public void setApp_channel(int app_channel) {
        this.app_channel = app_channel;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getRelease_notes() {
        return release_notes;
    }

    public void setRelease_notes(String release_notes) {
        this.release_notes = release_notes;
    }

    public String getVersion_number() {
        return version_number;
    }

    public void setVersion_number(String version_number) {
        this.version_number = version_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isForce_update() {
        return force_update;
    }

    public void setForce_update(boolean force_update) {
        this.force_update = force_update;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getRelease_title() {
        return release_title;
    }

    public void setRelease_title(String release_title) {
        this.release_title = release_title;
    }
}
