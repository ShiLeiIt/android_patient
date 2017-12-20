package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/20.
 * 添加门诊信息
 */

public interface OutPatientAddView extends BaseView{
    //添加门诊信息保存
    String getParentUuid();
    String getDiagnosisDate();
    String getHospitalId();
    String getOfficeId();
    String getDoctorUuid();
    String getSummary();
    String getImageList();

    void LoadOutPatientSave(ResultModel<AddOutPatientDataSaveBean> model);
    void LoadOutPatientSaveText(ResultModel<AddOutPatientDataSaveBean> model);
}
