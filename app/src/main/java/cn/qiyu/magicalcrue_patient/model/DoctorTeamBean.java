package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/11/24.
 */

public class DoctorTeamBean {


    /**
     * id : 60
     * create_user : 1
     * doctor_name : 白景桐
     * uuid : b2ac6c0778d24704901248b9e500572f
     * team_name : 白景桐的工作组
     * status : 0
     * is_delete : 0
     */

    private int id;
    private String create_user;
    private String doctor_name;
    private String uuid;
    private String team_name;
    private int status;
    private int is_delete;
    private List<DoctorInfoBean> doctorTeamList;

    public List<DoctorInfoBean> getDoctorTeamList() {
        return doctorTeamList;
    }

    public void setDoctorTeamList(List<DoctorInfoBean> doctorTeamList) {
        this.doctorTeamList = doctorTeamList;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
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
