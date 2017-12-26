package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/5.
 * 公告列表信息
 */

public class InfoUserNoticeListBean {

    /**
     * create_time : 2017-12-25 17:46:55
     * title : qrtrfgg
     * uuid : 2de07c071b3a42c7865bca8e73ba4aa0
     * content : ghfvhvhh
     * status : 1
     */

    private String create_time;
    private String title;
    private String uuid;
    private String content;
    private int status;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
