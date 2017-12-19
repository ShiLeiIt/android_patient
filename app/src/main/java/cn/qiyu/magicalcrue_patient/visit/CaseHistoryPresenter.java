package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.CommentVisitDialogueBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 病历
 */

public class CaseHistoryPresenter {
    private CaseHistoryView mCaseHistoryView;
    private CaseHistoryHospitalListView mCaseHistoryHospitalListView;
    private CaseHistoryBiz mCaseHistoryBiz;

    public CaseHistoryPresenter(CaseHistoryView caseHistoryView) {
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryView = caseHistoryView;
    }
    public CaseHistoryPresenter(CaseHistoryHospitalListView caseHistoryHospitalListView){
        mCaseHistoryBiz = new CaseHistoryBizImpl();
        mCaseHistoryHospitalListView = caseHistoryHospitalListView;
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
}
