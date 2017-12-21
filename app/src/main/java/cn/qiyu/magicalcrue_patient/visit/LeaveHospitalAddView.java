package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/20.
 * 添加出院小结信息
 */

public interface LeaveHospitalAddView extends BaseView{
    //添加出院小结保存
    String getParentUuid();
    String getBeHospitalDate();
    String getLeaveHospitalDate();
    String getHospitalId();
    String getHospitalizationOfficeId();
    String getDoctorName();
    String getSummary();
    String getImageList();

    void LoadLeaveHospitalSave(ResultModel<AddOutPatientDataSaveBean> model);
    void LoadLeaveHospitalSaveText(ResultModel<AddOutPatientDataSaveBean> model);
}
