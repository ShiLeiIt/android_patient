package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 * 随访消息
 */

public class FollowUpMessageDetaild {

    /**
     * order_no : 2017120534551
     * commentList : [{"user_role":1,"consultation_id":"12d0030f63d646bbb45c6b12d8997370","create_time":1512439277000,"user_id":"14cbff3d59d249528dcb9fd1c0aa318b","id":254,"userName":"磊","uuid":"78490e75720b4eada3c57a29d303feb8","content":"你好","status":0,"is_delete":0},{"user_role":1,"consultation_id":"12d0030f63d646bbb45c6b12d8997370","create_time":1512439284000,"user_id":"14cbff3d59d249528dcb9fd1c0aa318b","id":255,"userName":"磊","uuid":"2bc079d29d47441ab5df3557cfed5b0b","content":"你好","status":0,"is_delete":0},{"user_role":1,"consultation_id":"12d0030f63d646bbb45c6b12d8997370","create_time":1512439771000,"user_id":"14cbff3d59d249528dcb9fd1c0aa318b","id":256,"userName":"磊","uuid":"91b49b004d7e43408a02448850737dfc","content":"我是","status":0,"is_delete":0}]
     * create_time : 2017-12-05 10:00:25
     * photoPath : 47fdc25b7ab74160b20c816d948d1227
     * user_name : 磊
     * consultation_type : 1
     * order_price : 0
     * enclosureList : [{"picPath3":"http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260.jpg","id":"0b6b648084254b95b08be1b3d4e4c260"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/ed98617f19c740e0aecdd9285634b4a8_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/ed98617f19c740e0aecdd9285634b4a8_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/ed98617f19c740e0aecdd9285634b4a8_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/ed98617f19c740e0aecdd9285634b4a8.jpg","id":"ed98617f19c740e0aecdd9285634b4a8"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/74c30e7ccec44b43865bd3fc633fc36d_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/74c30e7ccec44b43865bd3fc633fc36d_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/74c30e7ccec44b43865bd3fc633fc36d_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/74c30e7ccec44b43865bd3fc633fc36d.jpg","id":"74c30e7ccec44b43865bd3fc633fc36d"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/54c51b72a9f14c2a90e049bf384f1f86_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/54c51b72a9f14c2a90e049bf384f1f86_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/54c51b72a9f14c2a90e049bf384f1f86_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/54c51b72a9f14c2a90e049bf384f1f86.jpg","id":"54c51b72a9f14c2a90e049bf384f1f86"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/48c873e30327406687bdf8cde348a1f4_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/48c873e30327406687bdf8cde348a1f4_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/48c873e30327406687bdf8cde348a1f4_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/48c873e30327406687bdf8cde348a1f4.jpg","id":"48c873e30327406687bdf8cde348a1f4"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/657dbc4db16940b3a887f6ab1b12b5f1_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/657dbc4db16940b3a887f6ab1b12b5f1_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/657dbc4db16940b3a887f6ab1b12b5f1_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/657dbc4db16940b3a887f6ab1b12b5f1.jpg","id":"657dbc4db16940b3a887f6ab1b12b5f1"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/51434cae6d5044f3b61f3dfd441eec9a_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/51434cae6d5044f3b61f3dfd441eec9a_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/51434cae6d5044f3b61f3dfd441eec9a_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/51434cae6d5044f3b61f3dfd441eec9a.jpg","id":"51434cae6d5044f3b61f3dfd441eec9a"},{"picPath3":"http://file.mircalcure.com/formalFile/20171205/60ab02f791a94c289b24d02fd4e94c97_3.jpg","picPath1":"http://file.mircalcure.com/formalFile/20171205/60ab02f791a94c289b24d02fd4e94c97_1.jpg","picPath2":"http://file.mircalcure.com/formalFile/20171205/60ab02f791a94c289b24d02fd4e94c97_2.jpg","filePath":"http://file.mircalcure.com/formalFile/20171205/60ab02f791a94c289b24d02fd4e94c97.jpg","id":"60ab02f791a94c289b24d02fd4e94c97"}]
     * uuid : 12d0030f63d646bbb45c6b12d8997370
     * is_delete : 0
     * relationshipName : 外婆
     * doctor_id : 95bbb5cb43ec43b58b464e89be63a585
     * complaint : 你好啊医生
     * user_id : 14cbff3d59d249528dcb9fd1c0aa318b
     * patient_id : f1275a99d4794e2abc535711904e0efb
     * patient_name : 怎么回事
     * id : 913
     * userType : 1
     * doctor_name : 白景桐
     * status : 1
     */

    private String order_no;
    private String create_time;
    private String photoPath;
    private String user_name;
    private int consultation_type;
    private int order_price;
    private String uuid;
    private int is_delete;
    private String relationshipName;
    private String doctor_id;
    private String complaint;
    private String user_id;
    private String patient_id;
    private String patient_name;
    private int id;
    private int userType;
    private String doctor_name;
    private int status;
    private List<Comment> commentList;
    private List<EncloSure> enclosureList;
    private EventInfoBean eventInfo;
    private CourseInfoBean courseInfo;

    public EventInfoBean getEventInfoBean() {
        return eventInfo;
    }

    public void setEventInfoBean(EventInfoBean eventInfoBean) {
        eventInfo = eventInfoBean;
    }

    public CourseInfoBean getCourseInfoBean() {
        return courseInfo;
    }

    public void setCourseInfoBean(CourseInfoBean courseInfoBean) {
        courseInfo = courseInfoBean;
    }

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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<EncloSure> getEnclosureList() {
        return enclosureList;
    }

    public void setEnclosureList(List<EncloSure> enclosureList) {
        this.enclosureList = enclosureList;
    }
}
