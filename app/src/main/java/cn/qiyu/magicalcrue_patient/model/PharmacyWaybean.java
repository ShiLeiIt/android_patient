package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/21.
 * 获取用药方式bean及症状Bean
 */

public class PharmacyWaybean {
    /**
     * ORDER_BY : 1
     * DICTIONARIES_ID : 41c9d2dd73754588b11a27de49a35e87
     * NAME_EN : koufu
     * BIANMA : koufu
     * is_parent : 0
     * NAME : 口服
     * PARENT_ID : 1bfd7b4ec2694934831bbfb14ce3c6df
     */

    private int ORDER_BY;
    private String DICTIONARIES_ID;
    private String NAME_EN;
    private String BIANMA;
    private int is_parent;
    private String NAME;
    private String PARENT_ID;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getORDER_BY() {
        return ORDER_BY;
    }

    public void setORDER_BY(int ORDER_BY) {
        this.ORDER_BY = ORDER_BY;
    }

    public String getDICTIONARIES_ID() {
        return DICTIONARIES_ID;
    }

    public void setDICTIONARIES_ID(String DICTIONARIES_ID) {
        this.DICTIONARIES_ID = DICTIONARIES_ID;
    }

    public String getNAME_EN() {
        return NAME_EN;
    }

    public void setNAME_EN(String NAME_EN) {
        this.NAME_EN = NAME_EN;
    }

    public String getBIANMA() {
        return BIANMA;
    }

    public void setBIANMA(String BIANMA) {
        this.BIANMA = BIANMA;
    }

    public int getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(String PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }
}
