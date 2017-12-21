package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/30.
 * 用药方案列表
 */

public interface CaseHistoryPharcyRdListView extends BaseView {

    String getPatientUuid();
    String getPage();
    String getPageCount();
    //获取用药方案记录列表
   void LoadPharcyRecodeList(ResultModel<List<PharmacyBean>> model);

}
