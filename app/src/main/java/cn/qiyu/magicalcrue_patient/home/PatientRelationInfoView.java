package cn.qiyu.magicalcrue_patient.home;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public interface PatientRelationInfoView extends BaseView {
    //获取患者列表
     String  getBianMa();
    String getType();
    void LoadPatientRelation(ResultModel<List<PatientRelationBean>> model);

    //获取疾病种类列表
    void LoadDiseases(ResultModel<List<DiseasesBean>> model);

}
