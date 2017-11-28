package cn.qiyu.magicalcrue_patient.mine;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;

/**
 * Created by ShiLei on 2017/11/15.
 */

public interface MineInforView extends BaseView {
     String  getUserUuid();
     String  getPatientBasicUuid();

    void getUserBasicInfor(ResultModel<UserInfor> userInforResultModel);
    void getPatientBasicInfor(ResultModel<PatientInfor> patientInforResultModel);



}
