package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/12/22.
 * 身体症状记录Bean
 */

public class SymptomatographyBean {
    /**
     * commentList : []
     * symptom_code : 四肢乏力
     * symptom : 没劲
     * create_time : 2017-12-22 10:42:22
     * patientId : f1275a99d4794e2abc535711904e0efb
     * id : 108
     * uuid : 41a7a085d0ab44a5b0463e402356b2ca
     * imglist : [{"picPath3":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_3.png","picPath1":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_1.png","picPath2":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965_2.png","file_id":"90f61aafdae94d2ab41dada28fd16965","filePath":"http://file.mircalcure.com/formalFile/20171222/90f61aafdae94d2ab41dada28fd16965.png"}]
     * remarks : 感冒，发烧
     * status : 0
     * is_delete : 0
     */
    private String symptom_code;
    private String symptom;
    private String create_time;
    private String patientId;
    private int id;
    private String uuid;
    private String remarks;
    private int status;
    private int is_delete;
    private List<Comment> commentList;
    private List<EncloSure> imglist;

    public String getSymptom_code() {
        return symptom_code;
    }

    public void setSymptom_code(String symptom_code) {
        this.symptom_code = symptom_code;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
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
