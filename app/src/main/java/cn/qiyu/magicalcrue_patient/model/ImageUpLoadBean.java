package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/11/22.
 */

public class ImageUpLoadBean {


    /**
     * result : 0
     * message : null
     * data : {"FileName":"20180205-142311-89792fc7a9804183985aa51de91f146e.png","Success":true}
     * errorCode : null
     */

    private int result;
    private String message;
    private DataBean data;
    private String errorCode;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static class DataBean {
        /**
         * FileName : 20180205-142311-89792fc7a9804183985aa51de91f146e.png
         * Success : true
         */

        private String FileName;
        private boolean Success;

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String FileName) {
            this.FileName = FileName;
        }

        public boolean isSuccess() {
            return Success;
        }

        public void setSuccess(boolean Success) {
            this.Success = Success;
        }
    }
}
