package cn.qiyu.magicalcrue_patient.model;

import java.util.List;

/**
 * Created by ShiLei on 2017/11/22.
 */

public class ImageUpLoadBean
{

    /**
     * result : 0
     * message : 上传成功！
     * filePath : uploadFiles/uploadImgs
     * fileNewName : 5c5d53772a0848519f8a245b2dbf1acb.jpg
     * fileId : null
     * fileIds : null
     * fileList : [{"fileOldName":"奇愈记-登录-患者2.jpg","fileNewName":"5c5d53772a0848519f8a245b2dbf1acb.jpg"}]
     * varList : []
     * filePath1 : null
     * filePath2 : null
     * filePath3 : null
     */

    private int result;
    private String message;
    private String filePath;
    private String fileNewName;
    private String fileId;
    private String fileIds;
    private String filePath1;
    private String filePath2;
    private String filePath3;
    private List<ImageInforBean> varList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileNewName() {
        return fileNewName;
    }

    public void setFileNewName(String fileNewName) {
        this.fileNewName = fileNewName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public String getFilePath1() {
        return filePath1;
    }

    public void setFilePath1(String filePath1) {
        this.filePath1 = filePath1;
    }

    public String getFilePath2() {
        return filePath2;
    }

    public void setFilePath2(String filePath2) {
        this.filePath2 = filePath2;
    }

    public String getFilePath3() {
        return filePath3;
    }

    public void setFilePath3(String filePath3) {
        this.filePath3 = filePath3;
    }

    public List<ImageInforBean> getVarList() {
        return varList;
    }

    public void setVarList(List<ImageInforBean> varList) {
        this.varList = varList;
    }
}
