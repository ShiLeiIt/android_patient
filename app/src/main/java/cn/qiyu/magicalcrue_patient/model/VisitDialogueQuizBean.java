package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/13.
 * 随访对话提问
 */

public class VisitDialogueQuizBean {

    /**
     * result : 0
     * message : 成功
     * data : {"order_no":"2017121375377","create_time":"2017-12-13 13:20:27","consultation_type":1,"order_price":0,"uuid":"b0a02eb4e92a4d5c8e378bf3bbc69185","is_delete":0,"doctor_id":"95bbb5cb43ec43b58b464e89be63a585","complaint":"678965","user_id":"14cbff3d59d249528dcb9fd1c0aa318b","patient_id":"f1275a99d4794e2abc535711904e0efb","patient_name":"怎么回事","id":953,"doctor_name":"白景桐","status":1}
     * errorCode : null
     */

    private int result;
    private String message;
    private VisitDialogueQuizItemBean mVisitDialogueQuizItemBean;
    private String errorCode;

    public VisitDialogueQuizItemBean getVisitDialogueQuizItemBean() {
        return mVisitDialogueQuizItemBean;
    }

    public void setVisitDialogueQuizItemBean(VisitDialogueQuizItemBean visitDialogueQuizItemBean) {
        mVisitDialogueQuizItemBean = visitDialogueQuizItemBean;
    }

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



    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
