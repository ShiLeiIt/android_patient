package cn.qiyu.magicalcrue_patient.visit;

import android.util.Log;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 病历
 */

public class CaseHistoryPresenter {
    private CaseHistoryView mCaseHistoryView;
    private CaseHistoryHospitalListView mCaseHistoryHospitalListView;
    private CaseHistoryHospitalOfficeListView mCaseHistoryHospitalOfficeListView;
    private CaseHistoryPharcyRdListView mCaseHistoryPharcyRdListView;



    private CaseHistoryBiz mCaseHistoryBiz;
    //病历
    public CaseHistoryPresenter(CaseHistoryView caseHistoryView) {
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryView = caseHistoryView;
    }
    //医院列表
    public CaseHistoryPresenter(CaseHistoryHospitalListView caseHistoryHospitalListView){
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryHospitalListView = caseHistoryHospitalListView;
    }
    //科室列表
    public CaseHistoryPresenter(CaseHistoryHospitalOfficeListView caseHistoryHospitalOfficeListView){
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryHospitalOfficeListView = caseHistoryHospitalOfficeListView;
    }

    //用药方案记录列表
    public CaseHistoryPresenter(CaseHistoryPharcyRdListView caseHistoryPharcyRdListView){
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryPharcyRdListView = caseHistoryPharcyRdListView;
    }


    //获取门诊资料信息列表
    public void getOutPatientInfoList() {
        mCaseHistoryBiz.getOutpatientInfo(mCaseHistoryView.getParentUuid(), mCaseHistoryView.getPage(), mCaseHistoryView.getPageCount(), new CaseHistoryBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mCaseHistoryView.LoadOutPatientInfoList(model);
                } else {
                    mCaseHistoryView.onViewFailure(model);
                }

            }

            @Override
            public void onFailure(String e) {
                mCaseHistoryView.onServerFailure(e);
            }
        });
    }

    //获取出院小结信息
    public void getLeaveHospitalInfoList() {
        mCaseHistoryBiz.getLeaveHospitalInfo(mCaseHistoryView.getParentUuid(), mCaseHistoryView.getPage(), mCaseHistoryView.getPageCount(), new CaseHistoryBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mCaseHistoryView.LoadLeaveHospitalInfoList(model);
                } else {
                    mCaseHistoryView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
                mCaseHistoryView.onServerFailure(e);
            }
        });
    }

    //获取医院列表信息
    public void getHospitalList(){
      mCaseHistoryBiz.getHospitalList(mCaseHistoryHospitalListView.getKeyWords(), mCaseHistoryHospitalListView.getPage(), mCaseHistoryHospitalListView.getPageCount(), new CaseHistoryBiz.OnLoginListener() {
          @Override
          public void onResponse(ResultModel model) {
              if (model.getResult() == 0) {
                  mCaseHistoryHospitalListView.LoadHospitalList(model);
              } else {
                  mCaseHistoryHospitalListView.onViewFailure(model);
              }
          }

          @Override
          public void onFailure(String e) {
            mCaseHistoryHospitalListView.onServerFailure(e);
          }
      });
  }
    //获取医院科室列表信息
    public  void getHospitalOfficeList(){
        mCaseHistoryBiz.getHospitalOfficeList(mCaseHistoryHospitalOfficeListView.getPage(), mCaseHistoryHospitalOfficeListView.getPageCount(), new CaseHistoryBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mCaseHistoryHospitalOfficeListView.LoadHospitalOfficeList(model);
                } else {
                    mCaseHistoryHospitalOfficeListView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
            mCaseHistoryHospitalOfficeListView.onServerFailure(e);
            }
        });
    }
    //获取用药方案记录列表
    public void getPharcyRecodeList(){
        mCaseHistoryBiz.getPhPharmacyRecordInfo(mCaseHistoryPharcyRdListView.getPatientUuid(), mCaseHistoryPharcyRdListView.getPage(), mCaseHistoryPharcyRdListView.getPageCount(), new CaseHistoryBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mCaseHistoryPharcyRdListView.LoadPharcyRecodeList(model);
                } else {
                    mCaseHistoryPharcyRdListView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
            mCaseHistoryPharcyRdListView.onServerFailure(e);
            }
        });
    }


}
