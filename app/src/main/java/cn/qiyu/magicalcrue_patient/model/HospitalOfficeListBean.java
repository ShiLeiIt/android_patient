package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/20.
 * 科室列表
 */

public class HospitalOfficeListBean {

    /**
     * office_name : 肿瘤内科
     * id : 27
     * uuid : db4331b09834414fa3dbe9ff3aaf4b65
     */

    private String office_name;
    private int id;
    private String uuid;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
