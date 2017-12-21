package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/12/21.
 * 用药方案列表Bean
 */

public class PharmacyBean {

    /**
     * commentList : []
     * drug_name : 测试3
     * amount : 2
     * create_time : 2017-12-21 13:29:39
     * patientId : f1275a99d4794e2abc535711904e0efb
     * usaged : 口服
     * id : 39
     * uuid : a729af760ee64011a87d2802a191fd8c
     * imglist : [{"picPath3":"http://file.mircalcure.com/formalFile/20171221/d40e1d3809644bc78373e2f73708a326_3.png","picPath1":"http://file.mircalcure.com/formalFile/20171221/d40e1d3809644bc78373e2f73708a326_1.png","picPath2":"http://file.mircalcure.com/formalFile/20171221/d40e1d3809644bc78373e2f73708a326_2.png","file_id":"d40e1d3809644bc78373e2f73708a326","filePath":"http://file.mircalcure.com/formalFile/20171221/d40e1d3809644bc78373e2f73708a326.png"},{"picPath3":"http://file.mircalcure.com/formalFile/20171221/07a4b0b9909a49c1afd6ebbea05ff37e_3.png","picPath1":"http://file.mircalcure.com/formalFile/20171221/07a4b0b9909a49c1afd6ebbea05ff37e_1.png","picPath2":"http://file.mircalcure.com/formalFile/20171221/07a4b0b9909a49c1afd6ebbea05ff37e_2.png","file_id":"07a4b0b9909a49c1afd6ebbea05ff37e","filePath":"http://file.mircalcure.com/formalFile/20171221/07a4b0b9909a49c1afd6ebbea05ff37e.png"}]
     * remarks : 这是用药方案
     * is_delete : 0
     */

    private String drug_name;
    private String amount;
    private String create_time;
    private String patientId;
    private String usaged;
    private int id;
    private String uuid;
    private String remarks;
    private int is_delete;
    private List<Comment> commentList;
    private List<EncloSure> imglist;

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getUsaged() {
        return usaged;
    }

    public void setUsaged(String usaged) {
        this.usaged = usaged;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<EncloSure> getImglist() {
        return imglist;
    }

    public void setImglist(List<EncloSure> imglist) {
        this.imglist = imglist;
    }

    public static class ImglistBean {
    }
}
