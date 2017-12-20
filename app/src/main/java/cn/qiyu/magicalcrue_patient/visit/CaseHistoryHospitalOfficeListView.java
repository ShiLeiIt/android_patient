package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/30.
 * 科室列表
 */

public interface CaseHistoryHospitalOfficeListView extends BaseView {
    String getPage();
    String getPageCount();
    //获取医院列表
   void LoadHospitalOfficeList(ResultModel<List<HospitalOfficeListBean>> model);

}
