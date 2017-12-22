package cn.qiyu.magicalcrue_patient.visit;

import android.util.Log;

import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.biz.SymptomatographyAddBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/22.
 * 添加症状记录
 */

public class SymptomatographyAddPresenter {
    private SymptomatographyAddView mSymptomatographyAddView;

    private SymptomatographyAddBiz mSymptomatographyAddBiz;
    //病历
    public SymptomatographyAddPresenter(SymptomatographyAddView symptomatographyAddView) {
        mSymptomatographyAddBiz = new SymptomatographyAddBizImpl();
        mSymptomatographyAddView = symptomatographyAddView;
    }


    //添加症状记录保存带图片
    public  void getSymptomatographySave(){
        mSymptomatographyAddBiz.addSymptomatographySave(mSymptomatographyAddView.getParentUuid(),
                mSymptomatographyAddView.getSymptomCode(), mSymptomatographyAddView.getSymptom(),
                mSymptomatographyAddView.getRemarks(), mSymptomatographyAddView.getImageList(), new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mSymptomatographyAddView.LoadSymptomatographySave(model);
                        } else {
                            mSymptomatographyAddView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mSymptomatographyAddView.onServerFailure(e);
                    }
                }
        );

    }
    //添加症状记录保存不带图片
    public  void getSymptomatographySaveText(){
        mSymptomatographyAddBiz.addSymptomatographySaveText(mSymptomatographyAddView.getParentUuid(),
                mSymptomatographyAddView.getSymptomCode(), mSymptomatographyAddView.getSymptom(),
                mSymptomatographyAddView.getRemarks(), new CaseHistoryBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mSymptomatographyAddView.LoadSymptomatographyAddSaveText(model);
                        } else {
                            mSymptomatographyAddView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mSymptomatographyAddView.onServerFailure(e);
                    }
                }

        );
    }


}
