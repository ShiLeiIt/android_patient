package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 门诊资料和医院小结列表Bean
 */

public class DischargeBean {



    /**
     * summary : 单独的
     * hospitalization_office_id : db4331b09834414fa3dbe9ff3aaf4b65
     * create_time : 2017-12-15 16:51:40
     * be_hospitalized_date : 1507046400000
     * hospitalName : 中国医学科学院肿瘤医院
     * hospital_id : 171
     * uuid : b634d75c34304c51989e869b4a9fc752
     * imglist : [{"picPath3":"http://file.mircalcure.com/formalFile/20171215/6a17fc56d13f4ee89949d093962222eb_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171215/6a17fc56d13f4ee89949d093962222eb_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171215/6a17fc56d13f4ee89949d093962222eb_2.jpg","file_id":"6a17fc56d13f4ee89949d093962222eb","filePath":"http://file.mircalcure.com/formalFile/20171215/6a17fc56d13f4ee89949d093962222eb.jpg"}]
     * is_delete : 0
     * office_name : 肿瘤内科
     * doctorName : 尔康
     * leave_hospital_date : 1512489600000
     * id : 64
     * create_user : 1
     * doctor_name : 尔康
     * health_file_id : 792d555029104f00bffff0ae048b864e
     * hospital_name : 中国医学科学院肿瘤医院
     * status : 0

     */
    private List<Comment> commentList;
    private String summary;
    private String hospitalization_office_id;
    private String create_time;
    private long be_hospitalized_date;
    private String hospitalName;
    private int hospital_id;
    private String uuid;
    private String doctorinfo_id;

    public String getDoctorinfo_id() {
        return doctorinfo_id;
    }

    public void setDoctorinfo_id(String doctorinfo_id) {
        this.doctorinfo_id = doctorinfo_id;
    }

    private int is_delete;
    private String office_name;
    private String doctorName;
    private long leave_hospital_date;
    private int id;
    private String create_user;
    private String doctor_name;
    private String health_file_id;
    private String hospital_name;
    private int status;
    private List<EncloSure> imglist;


    public List<EncloSure> getImglist() {
        return imglist;
    }
    public void setImglist(List<EncloSure> imglist) {
        this.imglist = imglist;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHospitalization_office_id() {
        return hospitalization_office_id;
    }

    public void setHospitalization_office_id(String hospitalization_office_id) {
        this.hospitalization_office_id = hospitalization_office_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public long getBe_hospitalized_date() {
        return be_hospitalized_date;
    }

    public void setBe_hospitalized_date(long be_hospitalized_date) {
        this.be_hospitalized_date = be_hospitalized_date;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
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

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public long getLeave_hospital_date() {
        return leave_hospital_date;
    }

    public void setLeave_hospital_date(long leave_hospital_date) {
        this.leave_hospital_date = leave_hospital_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getHealth_file_id() {
        return health_file_id;
    }

    public void setHealth_file_id(String health_file_id) {
        this.health_file_id = health_file_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
