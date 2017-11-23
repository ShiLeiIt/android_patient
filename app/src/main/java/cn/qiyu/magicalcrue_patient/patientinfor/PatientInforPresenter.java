package cn.qiyu.magicalcrue_patient.patientinfor;

import cn.qiyu.magicalcrue_patient.biz.PatientInforBiz;
import cn.qiyu.magicalcrue_patient.biz.UserInforEdtBiz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class PatientInforPresenter {

    private final PatientInforBiz mPatientInforBiz;
    private final PatientInforView mPatientInfoView;

    public PatientInforPresenter(PatientInforView patientInfoView) {
        mPatientInforBiz = new PatientInforBizImpl();
        mPatientInfoView = patientInfoView;
    }
    public  void getPatientInforCom(){
        mPatientInforBiz.getPatientInfor(mPatientInfoView.getUserId(),
                mPatientInfoView.getPatientName(),
                mPatientInfoView.getSex(),
                mPatientInfoView.getBirthday(),
                mPatientInfoView.getIdCardNO(),
                mPatientInfoView.getMobile(),
                mPatientInfoView.getNative_place_cd(),
                mPatientInfoView.getAttending_doctor(),
                mPatientInfoView.getFirstVisitTime(),
                mPatientInfoView.getRelationship(),
                mPatientInfoView.getDisease_id(),
                mPatientInfoView.getAppFirstVisitTime(), new PatientInforBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mPatientInfoView.getPatientInfor(model);
                        } else {
                            mPatientInfoView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mPatientInfoView.onServerFailure(e);
                    }
                });
    }



}
