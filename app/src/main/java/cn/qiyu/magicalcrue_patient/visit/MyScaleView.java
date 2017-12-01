package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;

/**
 * Created by ShiLei on 2017/11/30.
 */

public interface MyScaleView extends BaseView {
    //量表
     String  getPatientUuid();
     String  getStatus();
     String  getPage();
     String  getPagecount();
    void LoadDate(ResultModel<List<MyScaleBean>> model);

    //量表详情
    String paperId();

    String paperUserId();

    String userId();

    void LoadScaleDetailsData(ResultModel<ScaleDetailBean> model);




}
