package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/22.
 * 添加症状记录
 */

public interface SymptomatographyAddView extends BaseView{
    //添加门诊信息保存
    String getParentUuid();
    String getSymptomCode();
    String getSymptom();
    String getRemarks();
    String getImageList();
    void LoadSymptomatographySave(ResultModel<AddOutPatientDataSaveBean> model);
    void LoadSymptomatographyAddSaveText(ResultModel<AddOutPatientDataSaveBean> model);
}
