package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/19.
 * 病历列表数目
 */

public class CaseHistoryNumBean {


    /**
     *
     * 门诊资料数:outpatientCount :30
     * 出院小结:hospitalizationCount : 5
     * 检查报告单:inspectCount : 7
     * 用药方案记录:durgRecordCount : 5
     * 身体症状记录:symtomReordCount : 4
     */

    private int outpatientCount;
    private int hospitalizationCount;
    private int inspectCount;
    private int durgRecordCount;
    private int symtomReordCount;

    public int getOutpatientCount() {
        return outpatientCount;
    }

    public void setOutpatientCount(int outpatientCount) {
        this.outpatientCount = outpatientCount;
    }

    public int getHospitalizationCount() {
        return hospitalizationCount;
    }

    public void setHospitalizationCount(int hospitalizationCount) {
        this.hospitalizationCount = hospitalizationCount;
    }

    public int getInspectCount() {
        return inspectCount;
    }

    public void setInspectCount(int inspectCount) {
        this.inspectCount = inspectCount;
    }

    public int getDurgRecordCount() {
        return durgRecordCount;
    }

    public void setDurgRecordCount(int durgRecordCount) {
        this.durgRecordCount = durgRecordCount;
    }

    public int getSymtomReordCount() {
        return symtomReordCount;
    }

    public void setSymtomReordCount(int symtomReordCount) {
        this.symtomReordCount = symtomReordCount;
    }
}
