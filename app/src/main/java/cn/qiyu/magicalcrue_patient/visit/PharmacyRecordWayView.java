package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyWaybean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/21.
 *  获取用药方式
 */

public interface PharmacyRecordWayView extends BaseView{
    //获取用药方式
    String getBianMa();
    String getType();
    void LoadPharmacyRecordWay(ResultModel<List<PharmacyWaybean>> model);
}
