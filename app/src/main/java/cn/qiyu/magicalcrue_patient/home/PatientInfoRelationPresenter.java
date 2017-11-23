package cn.qiyu.magicalcrue_patient.home;

import cn.qiyu.magicalcrue_patient.biz.PatientRelationInfoBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 患者关系
 */

public class PatientInfoRelationPresenter {
    private PatientRelationInfoView mPatientRelationInfoView;
    private PatientRelationInfoBiz mPatientInfoBiz;

    public PatientInfoRelationPresenter(PatientRelationInfoView patientRelationInfoView) {
        mPatientInfoBiz = new PatientRelationInfoBizImpl();
        mPatientRelationInfoView = patientRelationInfoView;
    }

    //加载患者列表
    public void LoadPatientRelation() {
        mPatientInfoBiz.getPatientRelation(mPatientRelationInfoView.getBianMa(), mPatientRelationInfoView.getType(), new PatientRelationInfoBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mPatientRelationInfoView.LoadPatientRelation(model);
                } else {
                    mPatientRelationInfoView.onServerFailure(model.getMessage());
                }
            }

            @Override
            public void onFailure(String e) {
                mPatientRelationInfoView.onServerFailure(e);
            }
        });
    }

    //加载疾病种类
    public void LoadDiseasesList() {
        mPatientInfoBiz.getDieasesList(new PatientRelationInfoBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mPatientRelationInfoView.LoadDiseases(model);
                        } else {
                            mPatientRelationInfoView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                    mPatientRelationInfoView.onServerFailure(e);
                    }
                }
        );
    }


}
