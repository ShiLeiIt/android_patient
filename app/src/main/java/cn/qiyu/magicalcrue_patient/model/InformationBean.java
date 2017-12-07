package cn.qiyu.magicalcrue_patient.model;

/**
 * Created by ShiLei on 2017/12/7.
 * 消息界面Bean
 */

public class InformationBean {
    InforItemBean noticeData;
    InforItemBean followData;
    InforItemBean messageData;

    public InforItemBean getNoticeData() {
        return noticeData;
    }

    public void setNoticeData(InforItemBean noticeData) {
        this.noticeData = noticeData;
    }

    public InforItemBean getFollowData() {
        return followData;
    }

    public void setFollowData(InforItemBean followData) {
        this.followData = followData;
    }

    public InforItemBean getMessageData() {
        return messageData;
    }

    public void setMessageData(InforItemBean messageData) {
        this.messageData = messageData;
    }
}
