package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/4.
 */

public class PaperData  implements Serializable{


    /**
     * create_time : 2017-12-04 16:27:48
     * remark : 测试
     * paperID : de9219ad2bbe441cbac111ae660d3738
     * paperTitle : 20170911测试1
     * status : 1
     */

    private String create_time;
    private String remark;
    private String paperID;
    private String paperTitle;
    private int status;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPaperID() {
        return paperID;
    }

    public void setPaperID(String paperID) {
        this.paperID = paperID;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
