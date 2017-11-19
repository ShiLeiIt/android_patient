package cn.qiyu.magicalcrue_patient.home;

import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientInfoBiz;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class PatientInfoPresenter {
    private PatientInfoView mPatientInfoView;
    private PatientInfoBiz mPatientInfoBiz;
    public PatientInfoPresenter(PatientInfoView patientInfoView){
        mPatientInfoBiz = new PatientInfoBizImpl();
        mPatientInfoView = patientInfoView;
    }
 public  void LoadPatientRelation(){
     mPatientInfoBiz.getPatientRelation(mPatientInfoView.getBianMa(), mPatientInfoView.getType(), new PatientInfoBiz.OnLoginListener() {
         @Override
         public void onResponse(ResultModel model) {
             if (model.getResult() == 0) {
                mPatientInfoView.LoadPatientRelation(model);
             } else {
                 mPatientInfoView.onServerFailure(model.getMessage());
             }
         }

         @Override
         public void onFailure(String e) {
             mPatientInfoView.onServerFailure(e);
         }
     });
 }
//    public void HomeDoctorData(){
//        mHomeBiz.getDoctorInfo(mNumView.getPatientId(), new HomeBiz.OnLoginListener() {
//            @Override
//            public void onResponse(ResultModel<HomeNumBean> model) {
//                if (model.getResult() == 0) {
//                    mNumView.LoadDate(model.getData());
//                } else {
//                    mNumView.onServerFailure(model.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(String e) {
//
//            }
//        });
//    }
}
