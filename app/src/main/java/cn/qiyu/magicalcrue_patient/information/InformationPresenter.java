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
    private InformationDoNoRdView mInformationDoNoRdView;
    private InformationFollowUpRdView mInformationFollowUpRdView;
    private InformationBiz mInformationBiz;

    public InformationPresenter(InformationView informationView){
        mInformationBiz = new InformationBizImpl();
        mInformationView = informationView;
    }
    //医生公告列表已读
    public InformationPresenter(InformationDoNoRdView informationDoNoRdView){
        mInformationBiz = new InformationBizImpl();
        mInformationDoNoRdView = informationDoNoRdView;
    }
    //消息随访对话已读
    public InformationPresenter(InformationFollowUpRdView informationFollowUpRdView){
        mInformationBiz = new InformationBizImpl();
        mInformationFollowUpRdView = informationFollowUpRdView;
    }


    //消息界面，医生公告列表
    public void  InformationDoctorNoticeList(){
        mInformationBiz.getUserNoticeList(mInformationView.getUserUuid(), mInformationView.getPage(), mInformationView.getPagecount(), new InformationBiz.OnLoginListener() {
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
    //获取医生公告列表已读
    public  void getDoctorNoticeRead(){
        mInformationBiz.getDoctorNoticeRead(mInformationDoNoRdView.getUserUuid(), mInformationDoNoRdView.getMessageUuid(), new InformationBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mInformationDoNoRdView.getDoctorNoticeRead(model);
                } else {
                    mInformationDoNoRdView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mInformationDoNoRdView.onServerFailure(e);
            }
        });
    }
    //获取消息中随访对话已读（Num为零）
    public void getFollowUpMsgRead() {
       mInformationBiz.getFollowUpMsgRead(mInformationFollowUpRdView.getUserUuid(), new InformationBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               if (model.getResult() == 0) {
                   mInformationFollowUpRdView.LoadFollowUpMsgRead(model);
               } else {
                   mInformationFollowUpRdView.onViewFailure(model);
               }
           }

           @Override
           public void onFailure(String e) {
                mInformationFollowUpRdView.onServerFailure(e);
           }
       });
    }





}
