package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/12/24.
 * 检查报告单列表Bean
 */

public class InspectionReportBean {


    /**
     * commentList : []
     * inspection_description : 可以
     * create_time : 2017-12-24 10:49:12
     * type_id : 1
     * inspection_date : 1514044800000
     * id : 113
     * uuid : a84cdf5dc8f04ae38e0739ab15e7ec94
     * imglist : [{"picPath3":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_3.png","picPath1":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_1.png","picPath2":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_2.png","file_id":"90f61aafdae94d2ab41dada28fd16965","filePath":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965.png"}]
     * patientinfo_id : f1275a99d4794e2abc535711904e0efb
     * status : 0
     * is_delete : 0
     * type_id: ECT
     typeName: ECT
     *
     */

    private String inspection_description;
    private String create_time;
    private String type_id;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;

    private long inspection_date;
    private int id;
    private String uuid;
    private String patientinfo_id;
    private int status;
    private int is_delete;

    private List<Comment> commentList;
    private List<EncloSure> imglist;

    public String getInspection_description() {
        return inspection_description;
    }

    public void setInspection_description(String inspection_description) {
        this.inspection_description = inspection_description;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public long getInspection_date() {
        return inspection_date;
    }

    public void setInspection_date(long inspection_date) {
        this.inspection_date = inspection_date;
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

    public String getPatientinfo_id() {
        return patientinfo_id;
    }

    public void setPatientinfo_id(String patientinfo_id) {
        this.patientinfo_id = patientinfo_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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


}
