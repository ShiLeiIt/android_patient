package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/24.
 * 添加检查报告单
 */

public interface InspectionReportAddView extends BaseView{
    //添加检查报告单保存
    String getParentUuid();
    String getInspectionDate();
    String getTypeId();
    String getInspectionDescription();
    String getImageList();
    void LoadInspectionReportAddSave(ResultModel<AddOutPatientDataSaveBean> model);
    void LoadInspectionReportAddSaveText(ResultModel<AddOutPatientDataSaveBean> model);
}
