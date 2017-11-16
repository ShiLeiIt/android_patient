package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class HomeDoctorBean {

    /**
     * doctorTeamList : [{"birthday":"1997-01-26","servicemotto":"包治百病","education":"dazhuan","headimg":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLk2IqY6lb70Uicy9kz1Lhib8MCCxykTe7OYCOiboKoElgOibPE47iaLlBwRqhwoUJMdibP2WSpOO0rhUMg/0","nation":"nation01","jobTitle":"护士","uuid":"4dfdb857c94748ea926f0954955d8ec1","skilled":"恶性淋巴瘤,肺癌,消化系统癌,乳腺癌","office_id":"0","marriage":1,"appType":1,"easemob_username":"13524402646430","id":430,"is_complete":1,"findings_audit":"","doctor_name":"王.祁路","job_title":"nana","native_place_cd":"250000","create_time":"2017-10-09 11:19:26","sex":1,"beginwork":"2010-02-02","profile":"一直从事恶性淋巴瘤综合治疗的研究工作，擅长于恶性淋巴瘤、肺癌、消化系统癌、乳腺癌等常见肿瘤或少见肿瘤的诊治。","mobile":"13524402646","wechat":"oB3qrw_hl9xnusyVpIxQw11Sw7HM","hospitalName":"中国医学科学院北京肿瘤医院","hospital_id":"175","photo_path":"31eade0bbb444c1db28bdc615f874cd5","register_id":"c38461dbd8ce4d47903fe12b05073a68","is_delete":0,"doctorRole":"groupDoctor","easemob_password":"123456","status":1}]
     * doctor_id : 4dfdb857c94748ea926f0954955d8ec1
     * create_time : 2017-10-09 13:18:30
     * modify_user : 1
     * modify_time : 2017-11-16 17:37:48
     * qyjDoctorList : [{"native_place_cd":"0","education":"--请选择--","create_time":"2017-10-20 13:21:11","nation":"--请选择--","sex":0,"profile":"奇遇记金牌医学顾问","hospitalName":"奇遇记金牌医学顾问","hospital_id":"167","uuid":"03f6907cc6ab468cae2ff5d5a78557f2","is_delete":0,"doctorRole":"medicalAdvisor","office_id":"0","marriage":0,"appType":0,"id":433,"is_complete":1,"create_user":"1","findings_audit":"","doctor_name":"奇遇记医学顾问","job_title":"--请选择--","status":1},{"native_place_cd":"0","education":"--请选择--","create_time":"2017-10-20 13:22:00","nation":"--请选择--","sex":0,"profile":"奇遇记客服","hospitalName":"奇遇记客服","hospital_id":"167","uuid":"82f38746439a4e4f90d2ff07507678d8","is_delete":0,"doctorRole":"medicalAdvisor","office_id":"0","marriage":0,"appType":0,"id":434,"is_complete":1,"create_user":"1","findings_audit":"","doctor_name":"奇遇记医学客服","job_title":"--请选择--","status":1}]
     * id : 49
     * doctor_name : 王.祁路
     * uuid : b5632473583c46a4be7b937fea33e6e0
     * team_name : 神医
     * status : 0
     * is_delete : 0
     */

    private String doctor_id;
    private String create_time;
    private String modify_user;
    private String modify_time;
    private int id;
    private String doctor_name;
    private String uuid;
    private String team_name;
    private int status;
    private int is_delete;
    private List<DoctorTeamListBean> doctorTeamList;
    private List<QyjDoctorListBean> qyjDoctorList;

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

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
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

    public List<DoctorTeamListBean> getDoctorTeamList() {
        return doctorTeamList;
    }

    public void setDoctorTeamList(List<DoctorTeamListBean> doctorTeamList) {
        this.doctorTeamList = doctorTeamList;
    }

    public List<QyjDoctorListBean> getQyjDoctorList() {
        return qyjDoctorList;
    }

    public void setQyjDoctorList(List<QyjDoctorListBean> qyjDoctorList) {
        this.qyjDoctorList = qyjDoctorList;
    }

    public static class DoctorTeamListBean {
        /**
         * birthday : 1997-01-26
         * servicemotto : 包治百病
         * education : dazhuan
         * headimg : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLk2IqY6lb70Uicy9kz1Lhib8MCCxykTe7OYCOiboKoElgOibPE47iaLlBwRqhwoUJMdibP2WSpOO0rhUMg/0
         * nation : nation01
         * jobTitle : 护士
         * uuid : 4dfdb857c94748ea926f0954955d8ec1
         * skilled : 恶性淋巴瘤,肺癌,消化系统癌,乳腺癌
         * office_id : 0
         * marriage : 1
         * appType : 1
         * easemob_username : 13524402646430
         * id : 430
         * is_complete : 1
         * findings_audit :
         * doctor_name : 王.祁路
         * job_title : nana
         * native_place_cd : 250000
         * create_time : 2017-10-09 11:19:26
         * sex : 1
         * beginwork : 2010-02-02
         * profile : 一直从事恶性淋巴瘤综合治疗的研究工作，擅长于恶性淋巴瘤、肺癌、消化系统癌、乳腺癌等常见肿瘤或少见肿瘤的诊治。
         * mobile : 13524402646
         * wechat : oB3qrw_hl9xnusyVpIxQw11Sw7HM
         * hospitalName : 中国医学科学院北京肿瘤医院
         * hospital_id : 175
         * photo_path : 31eade0bbb444c1db28bdc615f874cd5
         * register_id : c38461dbd8ce4d47903fe12b05073a68
         * is_delete : 0
         * doctorRole : groupDoctor
         * easemob_password : 123456
         * status : 1
         */

        private String birthday;
        private String servicemotto;
        private String education;
        private String headimg;
        private String nation;
        private String jobTitle;
        private String uuid;
        private String skilled;
        private String office_id;
        private int marriage;
        private int appType;
        private String easemob_username;
        private int id;
        private int is_complete;
        private String findings_audit;
        private String doctor_name;
        private String job_title;
        private String native_place_cd;
        private String create_time;
        private int sex;
        private String beginwork;
        private String profile;
        private String mobile;
        private String wechat;
        private String hospitalName;
        private String hospital_id;
        private String photo_path;
        private String register_id;
        private int is_delete;
        private String doctorRole;
        private String easemob_password;
        private int status;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getServicemotto() {
            return servicemotto;
        }

        public void setServicemotto(String servicemotto) {
            this.servicemotto = servicemotto;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getSkilled() {
            return skilled;
        }

        public void setSkilled(String skilled) {
            this.skilled = skilled;
        }

        public String getOffice_id() {
            return office_id;
        }

        public void setOffice_id(String office_id) {
            this.office_id = office_id;
        }

        public int getMarriage() {
            return marriage;
        }

        public void setMarriage(int marriage) {
            this.marriage = marriage;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public String getEasemob_username() {
            return easemob_username;
        }

        public void setEasemob_username(String easemob_username) {
            this.easemob_username = easemob_username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_complete() {
            return is_complete;
        }

        public void setIs_complete(int is_complete) {
            this.is_complete = is_complete;
        }

        public String getFindings_audit() {
            return findings_audit;
        }

        public void setFindings_audit(String findings_audit) {
            this.findings_audit = findings_audit;
        }

        public String getDoctor_name() {
            return doctor_name;
        }

        public void setDoctor_name(String doctor_name) {
            this.doctor_name = doctor_name;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public String getNative_place_cd() {
            return native_place_cd;
        }

        public void setNative_place_cd(String native_place_cd) {
            this.native_place_cd = native_place_cd;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBeginwork() {
            return beginwork;
        }

        public void setBeginwork(String beginwork) {
            this.beginwork = beginwork;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getHospital_id() {
            return hospital_id;
        }

        public void setHospital_id(String hospital_id) {
            this.hospital_id = hospital_id;
        }

        public String getPhoto_path() {
            return photo_path;
        }

        public void setPhoto_path(String photo_path) {
            this.photo_path = photo_path;
        }

        public String getRegister_id() {
            return register_id;
        }

        public void setRegister_id(String register_id) {
            this.register_id = register_id;
        }

        public int getIs_delete() {
            return is_delete;
        }

        public void setIs_delete(int is_delete) {
            this.is_delete = is_delete;
        }

        public String getDoctorRole() {
            return doctorRole;
        }

        public void setDoctorRole(String doctorRole) {
            this.doctorRole = doctorRole;
        }

        public String getEasemob_password() {
            return easemob_password;
        }

        public void setEasemob_password(String easemob_password) {
            this.easemob_password = easemob_password;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class QyjDoctorListBean {
        /**
         * native_place_cd : 0
         * education : --请选择--
         * create_time : 2017-10-20 13:21:11
         * nation : --请选择--
         * sex : 0
         * profile : 奇遇记金牌医学顾问
         * hospitalName : 奇遇记金牌医学顾问
         * hospital_id : 167
         * uuid : 03f6907cc6ab468cae2ff5d5a78557f2
         * is_delete : 0
         * doctorRole : medicalAdvisor
         * office_id : 0
         * marriage : 0
         * appType : 0
         * id : 433
         * is_complete : 1
         * create_user : 1
         * findings_audit :
         * doctor_name : 奇遇记医学顾问
         * job_title : --请选择--
         * status : 1
         */

        private String native_place_cd;
        private String education;
        private String create_time;
        private String nation;
        private int sex;
        private String profile;
        private String hospitalName;
        private String hospital_id;
        private String uuid;
        private int is_delete;
        private String doctorRole;
        private String office_id;
        private int marriage;
        private int appType;
        private int id;
        private int is_complete;
        private String create_user;
        private String findings_audit;
        private String doctor_name;
        private String job_title;
        private int status;

        public String getNative_place_cd() {
            return native_place_cd;
        }

        public void setNative_place_cd(String native_place_cd) {
            this.native_place_cd = native_place_cd;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getHospital_id() {
            return hospital_id;
        }

        public void setHospital_id(String hospital_id) {
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

        public String getDoctorRole() {
            return doctorRole;
        }

        public void setDoctorRole(String doctorRole) {
            this.doctorRole = doctorRole;
        }

        public String getOffice_id() {
            return office_id;
        }

        public void setOffice_id(String office_id) {
            this.office_id = office_id;
        }

        public int getMarriage() {
            return marriage;
        }

        public void setMarriage(int marriage) {
            this.marriage = marriage;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_complete() {
            return is_complete;
        }

        public void setIs_complete(int is_complete) {
            this.is_complete = is_complete;
        }

        public String getCreate_user() {
            return create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }

        public String getFindings_audit() {
            return findings_audit;
        }

        public void setFindings_audit(String findings_audit) {
            this.findings_audit = findings_audit;
        }

        public String getDoctor_name() {
            return doctor_name;
        }

        public void setDoctor_name(String doctor_name) {
            this.doctor_name = doctor_name;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
