package cn.qiyu.magicalcrue_patient.visit;

import android.util.Log;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.biz.PharmacyRecordAddBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/21.
 * 添加用药方案记录
 */

public class PharmacyRecordPresenter {
    private PharmacyRecordAddView mPharmacyRecordAddView;
    private PharmacyRecordWayView mPharmacyRecordWayView;

    private PharmacyRecordAddBiz mPharmacyRecordAddBiz;
    //添加用药方案
    public PharmacyRecordPresenter(PharmacyRecordAddView pharmacyRecordAddView) {
        mPharmacyRecordAddBiz = new PharmacyRecordAddBizImpl();
        mPharmacyRecordAddView = pharmacyRecordAddView;
    }

    //获取用药方式
    public PharmacyRecordPresenter(PharmacyRecordWayView pharmacyRecordWayView) {
        mPharmacyRecordAddBiz = new PharmacyRecordAddBizImpl();
        mPharmacyRecordWayView = pharmacyRecordWayView;
    }


    //添加用药方案记录保存带图片
    public  void getPharmacyRecodeSave(){
        mPharmacyRecordAddBiz.addPharmacyRecordSave(mPharmacyRecordAddView.getParentUuid(), mPharmacyRecordAddView.getDrugName(),
                mPharmacyRecordAddView.getUsaged(), mPharmacyRecordAddView.getAmount(), mPharmacyRecordAddView.getRemarks(), mPharmacyRecordAddView.getImageList(), new PharmacyRecordAddBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mPharmacyRecordAddView.LoadPharmacyRecordSave(model);
                        } else {
                            mPharmacyRecordAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mPharmacyRecordAddView.onServerFailure(e);
                    }
                }
        );
    }

    //添加用药方案记录保存不带图片
    public void getPharmacyRecodeSaveText(){
        mPharmacyRecordAddBiz.addPharmacyRecordSaveText(mPharmacyRecordAddView.getParentUuid(),
                mPharmacyRecordAddView.getDrugName(), mPharmacyRecordAddView.getUsaged(),
                mPharmacyRecordAddView.getAmount(), mPharmacyRecordAddView.getRemarks(), new PharmacyRecordAddBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mPharmacyRecordAddView.LoadPharmacyRecordSaveText(model);
                        } else {
                            mPharmacyRecordAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mPharmacyRecordAddView.onServerFailure(e);
                    }
                }
        );
    }
    //获取用药方式
    public  void getPharmacyRecordWay(){
        mPharmacyRecordAddBiz.getPharmacyWay(mPharmacyRecordWayView.getBianMa(), mPharmacyRecordWayView.getType(), new PharmacyRecordAddBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mPharmacyRecordWayView.LoadPharmacyRecordWay(model);
                } else {
                    mPharmacyRecordWayView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
                mPharmacyRecordWayView.onServerFailure(e);
            }
        });
    }


}
