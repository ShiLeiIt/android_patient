package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/13.
 * 随访对话提问
 */

public class VisitDialogueQuizItemBean {


    /**
     * order_no : 2017121375377
     * create_time : 2017-12-13 13:20:27
     * consultation_type : 1
     * order_price : 0
     * uuid : b0a02eb4e92a4d5c8e378bf3bbc69185
     * is_delete : 0
     * doctor_id : 95bbb5cb43ec43b58b464e89be63a585
     * complaint : 678965
     * user_id : 14cbff3d59d249528dcb9fd1c0aa318b
     * patient_id : f1275a99d4794e2abc535711904e0efb
     * patient_name : 怎么回事
     * id : 953
     * doctor_name : 白景桐
     * status : 1
     */

    private String order_no;
    private String create_time;
    private int consultation_type;
    private int order_price;
    private String uuid;
    private int is_delete;
    private String doctor_id;
    private String complaint;
    private String user_id;
    private String patient_id;
    private String patient_name;
    private int id;
    private String doctor_name;
    private int status;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getConsultation_type() {
        return consultation_type;
    }

    public void setConsultation_type(int consultation_type) {
        this.consultation_type = consultation_type;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
