package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/27.
 * 系统消息列表信息
 */

public class InfoUserSystemMsgListBean {


    /**
     * recipient_user : 14cbff3d59d249528dcb9fd1c0aa318b
     * service_type : 1018
     * service_uuid : ed444e3ce90e4325b4dd659c22151f4f&605
     * create_time : 2017-12-26 15:04:28
     * id : 3391
     * create_user : 95bbb5cb43ec43b58b464e89be63a585
     * title : 量表提醒
     * type : 1
     * uuid : d238858b5c6a460aa18f43b65543a071
     * content : 医生团队给您发了一份量表，请尽快填写。
     * status : 0
     * is_delete : 0
     */

    private String recipient_user;
    private int service_type;
    private String service_uuid;
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

    public int getService_type() {
        return service_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }

    public String getService_uuid() {
        return service_uuid;
    }

    public void setService_uuid(String service_uuid) {
        this.service_uuid = service_uuid;
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
