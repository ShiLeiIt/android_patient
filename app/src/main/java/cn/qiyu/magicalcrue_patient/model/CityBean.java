package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/20.
 */

public class CityBean {

    /**
     * code : 110000
     * pinyin : BeiJingShi
     * levelId : 0
     * name : 北京市
     */

    private String code;
    private String pinyin;
    private int levelId;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
