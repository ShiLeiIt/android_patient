package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.InspectionReportAddBiz;
import cn.qiyu.magicalcrue_patient.biz.SymptomatographyAddBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/22.
 * 添加检查报告单
 */

public class InspectionReportAddPresenter {
    private InspectionReportAddView mInspectionReportAddView;

    private InspectionReportAddBiz mInspectionReportAddBiz;

    public InspectionReportAddPresenter(InspectionReportAddView inspectionReportAddView) {
        mInspectionReportAddBiz = new InspectionReportAddBizImpl();
        mInspectionReportAddView = inspectionReportAddView;
    }

    //添加检查报告单保存带图片
    public void getInspectionReportSave() {
        mInspectionReportAddBiz.addInspectionReportSave(mInspectionReportAddView.getParentUuid(),
                mInspectionReportAddView.getInspectionDate(), mInspectionReportAddView.getTypeId(),
                mInspectionReportAddView.getInspectionDescription(), mInspectionReportAddView.getImageList(), new InspectionReportAddBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mInspectionReportAddView.LoadInspectionReportAddSave(model);
                        } else {
                            mInspectionReportAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mInspectionReportAddView.onServerFailure(e);
                    }
                }
        );
    }

    //添加症状记录保存不带图片
    public void getInspectionReportSaveText() {
        mInspectionReportAddBiz.addInspectionReportSaveText(mInspectionReportAddView.getParentUuid(),
                mInspectionReportAddView.getInspectionDate(), mInspectionReportAddView.getTypeId(),
                mInspectionReportAddView.getInspectionDescription(), new InspectionReportAddBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mInspectionReportAddView.LoadInspectionReportAddSaveText(model);
                        } else {
                            mInspectionReportAddView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mInspectionReportAddView.onServerFailure(e);
                    }
                }
        );
    }


}
