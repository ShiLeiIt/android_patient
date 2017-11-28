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
     * filePath : 20171128/6138e57b36ab453ca75a351df9c1594c.svg
     * fileNewName : null
     * fileId : 6138e57b36ab453ca75a351df9c1594c
     * fileIds : null
     * fileList : []
     * varList : []
     * filePath1 : null
     * filePath2 : null
     * filePath3 : null
     */

    private int result;
    private String message;
    private String filePath;
    private Object fileNewName;
    private String fileId;
    private Object fileIds;
    private Object filePath1;
    private Object filePath2;
    private Object filePath3;
    private List<?> fileList;
    private List<?> varList;

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

    public Object getFileNewName() {
        return fileNewName;
    }

    public void setFileNewName(Object fileNewName) {
        this.fileNewName = fileNewName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Object getFileIds() {
        return fileIds;
    }

    public void setFileIds(Object fileIds) {
        this.fileIds = fileIds;
    }

    public Object getFilePath1() {
        return filePath1;
    }

    public void setFilePath1(Object filePath1) {
        this.filePath1 = filePath1;
    }

    public Object getFilePath2() {
        return filePath2;
    }

    public void setFilePath2(Object filePath2) {
        this.filePath2 = filePath2;
    }

    public Object getFilePath3() {
        return filePath3;
    }

    public void setFilePath3(Object filePath3) {
        this.filePath3 = filePath3;
    }

    public List<?> getFileList() {
        return fileList;
    }

    public void setFileList(List<?> fileList) {
        this.fileList = fileList;
    }

    public List<?> getVarList() {
        return varList;
    }

    public void setVarList(List<?> varList) {
        this.varList = varList;
    }
}
