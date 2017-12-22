package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/30.
 * 病历
 */

public interface CaseHistoryView extends BaseView {

    String getPatientUuid();
    String getPage();
    String getPageCount();
    //获取门诊信息
   void LoadOutPatientInfoList(ResultModel<List<DischargeBean>> model);

    //获取出院小结信息
    void LoadLeaveHospitalInfoList(ResultModel<List<DischargeBean>> model);






}
