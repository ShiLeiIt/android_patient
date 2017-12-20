package cn.qiyu.magicalcrue_patient.visit;

import android.util.Log;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 病历
 */

public class OutPatientAddPresenter {
    private OutPatientAddView mOutPatientAddView;

    private OutPatientAddBiz mOutPatientAddBiz;
    //病历
    public OutPatientAddPresenter(OutPatientAddView outPatientAddView) {
        mOutPatientAddBiz = new OutPatientAddBizImpl();
        mOutPatientAddView = outPatientAddView;
    }


    //添加门诊信息保存带图片
    public  void getOutPatientSave(){
        mOutPatientAddBiz.addOutPatientSave(mOutPatientAddView.getParentUuid(), mOutPatientAddView.getDiagnosisDate()
                , mOutPatientAddView.getHospitalId(), mOutPatientAddView.getOfficeId(), mOutPatientAddView.getDoctorUuid(), mOutPatientAddView.getSummary(), mOutPatientAddView.getImageList(), new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mOutPatientAddView.LoadOutPatientSave(model);
                            Log.i("daitu===", "111111");
                        } else {
                            Log.i("daitu===", "222222");
                            mOutPatientAddView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mOutPatientAddView.onServerFailure(e);
                    }
                }
        );
    }
    //添加门诊信息保存不带图片
    public  void getOutPatientSaveText(){
        mOutPatientAddBiz.addOutPatientSaveText(mOutPatientAddView.getParentUuid(),
                mOutPatientAddView.getDiagnosisDate(), mOutPatientAddView.getHospitalId(),
                mOutPatientAddView.getOfficeId(),
                mOutPatientAddView.getDoctorUuid(), mOutPatientAddView.getSummary(), new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            Log.i("budaitu===", "33333");
                            mOutPatientAddView.LoadOutPatientSaveText(model);
                        } else {
                            Log.i("budaitu===", "44444");
                            mOutPatientAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mOutPatientAddView.onServerFailure(e);
                    }
                }
        );
    }


}
