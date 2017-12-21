package cn.qiyu.magicalcrue_patient.visit;

import android.util.Log;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.LeaveHospitalAddBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 出院小结
 */

public class LeaveHospitalAddPresenter {
    private LeaveHospitalAddView mLeaveHospitalAddView;

    private LeaveHospitalAddBiz mLeaveHospitalAddBiz;
    //出院小结
    public LeaveHospitalAddPresenter(LeaveHospitalAddView leaveHospitalAddView) {
        mLeaveHospitalAddBiz = new LeaveHospitalAddBizImpl();
        mLeaveHospitalAddView = leaveHospitalAddView;
    }


    //添加出院小结信息保存带图片
    public  void getLeaveHospitalSave(){
        mLeaveHospitalAddBiz.addLeaveHospitalSave(mLeaveHospitalAddView.getParentUuid(),
                mLeaveHospitalAddView.getBeHospitalDate(),
                mLeaveHospitalAddView.getLeaveHospitalDate(),
                mLeaveHospitalAddView.getHospitalId(),
                mLeaveHospitalAddView.getHospitalizationOfficeId(),
                mLeaveHospitalAddView.getDoctorName(),
                mLeaveHospitalAddView.getSummary(),
                mLeaveHospitalAddView.getImageList(), new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mLeaveHospitalAddView.LoadLeaveHospitalSave(model);
                        } else {
                            mLeaveHospitalAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mLeaveHospitalAddView.onServerFailure(e);
                    }
                }

        );

    }
    //添加出院小结信息保存不带图片
    public  void getLeaveHospitalSaveText(){
        mLeaveHospitalAddBiz.addLeaveHospitalSaveText(mLeaveHospitalAddView.getParentUuid(),
                mLeaveHospitalAddView.getBeHospitalDate(),
                mLeaveHospitalAddView.getLeaveHospitalDate(),
                mLeaveHospitalAddView.getHospitalId(),
                mLeaveHospitalAddView.getHospitalizationOfficeId(),
                mLeaveHospitalAddView.getDoctorName(),
                mLeaveHospitalAddView.getSummary(),
                new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mLeaveHospitalAddView.LoadLeaveHospitalSaveText(model);
                        } else {
                            mLeaveHospitalAddView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mLeaveHospitalAddView.onServerFailure(e);
                    }
                }

        );
    }


}
