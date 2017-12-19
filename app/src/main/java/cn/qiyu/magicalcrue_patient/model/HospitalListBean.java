package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/19.
 * 医院列表
 */

public class HospitalListBean {

    /**
     * zip : 200030
     * switchboard : 021—22200000
     * address : 上海市淮海西路241号
     * province : 190000
     * Introduction : 上海市胸科医院创建于1957年，为我国最早建立的集医疗、教学、科研为一体的，以诊治心、肺、食管、气管、纵隔疾病为主的三级甲等专科医院。1957年起被卫生部指定为全国心胸外科进修基地，1988年起成为原上海第二医科大学教学医院，1994年被评为三级甲等医院，2004年成为上海市红十字胸科医院，2005年成为上海交通大学附属胸科医院。医院先后获得“全国卫生系统先进集体”、“全国无烟单位”、“上海市职业道德建设十佳单位”、“市文明单位”八连冠等殊荣。
     * city : 190100
     * hospitalId : 167
     * district : 190104
     * hospitalName : 上海胸科医院
     * grades : 三级甲等
     */

    private String zip;
    private String switchboard;
    private String address;
    private String province;
    private String Introduction;
    private String city;
    private int hospitalId;
    private String district;
    private String hospitalName;
    private String grades;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSwitchboard() {
        return switchboard;
    }

    public void setSwitchboard(String switchboard) {
        this.switchboard = switchboard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }
}
