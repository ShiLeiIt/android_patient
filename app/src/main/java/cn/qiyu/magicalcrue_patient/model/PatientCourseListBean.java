package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2018/1/15.
 * 随访患教课堂列表bean
 */

public class PatientCourseListBean {

    /**
     * doctor_id : 5b9a9d6a0f4540ed8fd0734820fa82ef
     * create_time : 2018-01-12 11:51:25
     * patient_id : df430ac16590449cba026e34704190f3
     * id : 307
     * title : 肺癌放疗
     * uuid : e15cc9d57daa40969632c7668276ff4c
     * content : 一、        肺癌放疗定义放射治疗是治疗恶性肿瘤的主要方法之一，已经专门为治疗癌症诞生了一百多年。放射治疗是利用各类加速器所产生的...
     * url : http://139.196.25.52:83/news/special/2017/0528/16.html
     * status : 0
     * is_delete : 0
     */

    private String doctor_id;
    private String create_time;
    private String patient_id;
    private int id;
    private String title;
    private String uuid;
    private String content;
    private String url;
    private int status;
    private int is_delete;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
