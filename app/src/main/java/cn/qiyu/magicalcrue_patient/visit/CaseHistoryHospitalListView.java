package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/30.
 * 病历
 */

public interface CaseHistoryHospitalListView extends BaseView {

    String getKeyWords();
    String getPage();
    String getPageCount();
    //获取医院列表
   void LoadHospitalList(ResultModel<List<HospitalListBean>> model);

}
