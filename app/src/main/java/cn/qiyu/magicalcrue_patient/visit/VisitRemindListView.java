package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.PatientCourseListBean;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/15.
 * 随访提醒列表
 */

public interface VisitRemindListView extends BaseView {
    String getPatientUuid();
    String getPage();
    String getPageCount();
   void LoadVisitRemindList(ResultModel<List<RemindListBean>> model);

}
