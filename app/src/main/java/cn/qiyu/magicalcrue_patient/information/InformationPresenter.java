package cn.qiyu.magicalcrue_patient.information;

import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.biz.InformationBiz;
import cn.qiyu.magicalcrue_patient.home.HomeBizImpl;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class InformationPresenter {
    private InformationView mInformationView;
    private InformationBiz mInformationBiz;
    public InformationPresenter(InformationView informationView){
        mInformationBiz = new InformationBizImpl();
        mInformationView = informationView;
    }
    //消息界面，医生公告列表
    public void  InformationDoctorNoticeList(){
        mInformationBiz.getDoctorNoticeList(mInformationView.getDoctorUuid(), mInformationView.getPage(), mInformationView.getPagecount(), new InformationBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mInformationView.getDoctorNoticeList(model);
                } else {
                    mInformationView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mInformationView.onServerFailure(e);
            }
        });
    }
    //消息界面列表显示
    public  void InformationListShow(){
        mInformationBiz.getInformationList(mInformationView.getUserUuid(), new InformationBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mInformationView.getInformationList(model);
                } else {
                    mInformationView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mInformationView.onServerFailure(e);
            }
        });
    }






}
