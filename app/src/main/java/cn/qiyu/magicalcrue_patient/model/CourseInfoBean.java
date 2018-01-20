package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2018/1/19.
 * 随访对话（患教）
 */

public class CourseInfoBean {

    /**
     * doctor_id : a72a92c65b38442ebb64e1f97172d5e7
     * create_time : 2018-01-18 13:32:40
     * patient_id : 65055995b84f4f91b49fa6d0cdccd915
     * id : 322
     * title : 化疗常见不良反应处理
     * uuid : 3438c7794bb5405cab9a3520997cbb40
     * content : 1.消化系统毒性　　（1）恶心呕吐　　 恶心呕吐是抗肿瘤药物最常见不良反应，5羟色胺等多种神经递质与此有关。按照致吐能力将化疗药物分为...
     * url : http://cms.mircalcure.com/news/special/2017/0528/8.html
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
