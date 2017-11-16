package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

public class ResultModel<T> implements Serializable {


    /**
     * data : {}
     * errorCode : string
     * message : string
     * result : 0
     */

    private T data;
    private String errorCode;
    private String message;
    private int result;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
    }
}
