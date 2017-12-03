package cn.qiyu.magicalcrue_patient.patientinfor;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.PatientInforSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface PatientInforView extends BaseView {
    String getPatientUuid();
    String getUserId();
    String getPatientName();
    String getSex();
    String getBirthday();
    String getIdCardNO();
    String getMobile();
    String getNative_place_cd();
    String getAttending_doctor();
    String getFirstVisitTime();
    String getRelationship();
    String getDisease_id();
    String getAppFirstVisitTime();
    void getPatientInfor(ResultModel<PatientInforSaveBean> rlBean);


}
