package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/5.
 * 医生公告列表信息
 */

public class InfoDoctorNoticeListBean {

    /**
     * recipient_user : 95bbb5cb43ec43b58b464e89be63a585
     * create_time : 2017-12-05 15:06:46
     * id : 1662
     * create_user : 95bbb5cb43ec43b58b464e89be63a585
     * title : BAI
     * type : 2
     * uuid : 601254ee26ca41af89f129043af6a1fa
     * content : JING
     * status : 0
     * is_delete : 0
     */

    private String recipient_user;
    private String create_time;
    private int id;
    private String create_user;
    private String title;
    private int type;
    private String uuid;
    private String content;
    private int status;
    private int is_delete;

    public String getRecipient_user() {
        return recipient_user;
    }

    public void setRecipient_user(String recipient_user) {
        this.recipient_user = recipient_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
