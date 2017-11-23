package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/23.
 * 疾病种类列表
 */

public class DiseasesBean  {

    /**
     * cancerId : 45
     * cancerName : 非小细胞肺癌
     * icon :
     * uuid : 682811e744584b2083623fc0106f8695
     */

    private int cancerId;
    private String cancerName;
    private String icon;
    private String uuid;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getCancerId() {
        return cancerId;
    }

    public void setCancerId(int cancerId) {
        this.cancerId = cancerId;
    }

    public String getCancerName() {
        return cancerName;
    }

    public void setCancerName(String cancerName) {
        this.cancerName = cancerName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
