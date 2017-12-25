package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.CaseHistoryNumBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/25.
 * 病历数目
 */

public interface CaseHistoryNumView extends BaseView {
    String getPatientUuid();
    //获取所有病历数目
   void LoadCaseHistoryNum(ResultModel<CaseHistoryNumBean> model);

}
