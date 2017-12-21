package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/21.
 * 添加用药方案记录
 */

public interface PharmacyRecordAddView extends BaseView{
    //添加用药方案记录信息保存
    String getParentUuid();
    String getDrugName();
    String getUsaged();
    String getAmount();
    String getRemarks();
    String getImageList();

    void LoadPharmacyRecordSave(ResultModel<AddOutPatientDataSaveBean> model);
    void LoadPharmacyRecordSaveText(ResultModel<AddOutPatientDataSaveBean> model);
}
