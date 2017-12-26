package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by Administrator on 2017/12/21.
 */

public class WebViewBean {
    String tempUUID;
    String baseUrl;
    String tempDoctorUUID;
    public String getTempDoctorUUID() {
        return tempDoctorUUID;
    }

    public void setTempDoctorUUID(String tempDoctorUUID) {
        this.tempDoctorUUID = tempDoctorUUID;
    }
    public String getTempUUID() {
        return tempUUID;
    }

    public void setTempUUID(String tempUUID) {
        this.tempUUID = tempUUID;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
