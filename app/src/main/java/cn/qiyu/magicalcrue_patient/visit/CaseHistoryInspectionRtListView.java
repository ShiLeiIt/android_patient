package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.InspectionReportBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/24.
 * 检查报告单列表
 */

public interface CaseHistoryInspectionRtListView extends BaseView {

    String getPatientUuid();
    String getPage();
    String getPageCount();
    //获取用药方案记录列表
   void LoadInspectionReportList(ResultModel<List<InspectionReportBean>> model);

}
