package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by Administrator on 2017/12/5.
 * 评论
 */

public class Comment {

    /**
     * user_role : 1
     * consultation_id : 12d0030f63d646bbb45c6b12d8997370
     * create_time : 1512439277000
     * user_id : 14cbff3d59d249528dcb9fd1c0aa318b
     * id : 254
     * userName : 磊
     * uuid : 78490e75720b4eada3c57a29d303feb8
     * content : 你好
     * status : 0
     * is_delete : 0
     */

    private int user_role;
    private String consultation_id;
    private long create_time;
    private String user_id;
    private int id;
    private int type;
    private String userName;
    private String uuid;
    private String content;
    private int status;
    private int is_delete;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public String getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
