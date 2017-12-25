package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/25.
 */

public class HomeBannerBean {

    /**
     * imageId : 7a0a022b21f14568bab8e1d3755d8b17
     * filePath : http://file.mircalcure.com/formalFile/20171213/7a0a022b21f14568bab8e1d3755d8b17.png
     * type : patientHomeBanner
     * title : 奇愈记的故事
     * uuid : f0095c3bc8764aaf88d0b7a52de29f89
     * describes : 奇愈记的故事
     * jumpUrl : https://mp.weixin.qq.com/s?__biz=MzI4Mjc5NTAxNQ==&mid=2247483880&idx=1&sn=fd9165fcb9bfeee6ff745f3e90b03933
     */

    private String imageId;
    private String filePath;
    private String type;
    private String title;
    private String uuid;
    private String describes;
    private String jumpUrl;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }
}
