package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;

/**
 * Created by ShiLei on 2017/12/22.
 * 身体症状记录
 */

public interface CaseHistorySymgyListView extends BaseView {

    String getPatientUuid();
    String getPage();
    String getPageCount();
    //获取用药方案记录列表
   void LoadSymgyList(ResultModel<List<SymptomatographyBean>> model);

}
