package cn.qiyu.magicalcrue_patient.home;

import android.widget.Toast;

import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class HomePresenter {
    private HomeNumView mNumView;
    private HomeBiz mHomeBiz;
    public  HomePresenter(HomeNumView numView){
        mHomeBiz = new HomeBizImpl();
        mNumView = numView;
    }
    public void  HomeLoadNumData(){
        mHomeBiz.getUserMessageInfo(mNumView.getUserId(), new HomeBiz.OnLoginListener() {

            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mNumView.LoadDate(model);
                } else {
                    mNumView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
            mNumView.onServerFailure(e);
            }
        });
    }


    //获取医生二维码
    public void getDoctorQRcode(){
        mHomeBiz.getDoctorQRcode(mNumView.patientUuid(), mNumView.DoctorUuid(), new HomeBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mNumView.getDoctorQRcode(model);
                } else {
                    mNumView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mNumView.onServerFailure(e);
            }
        });
    }
    //获取医生团队信息
 public void getDoctorTeamInfo(){
     mHomeBiz.getDoctorTeamInfor(mNumView.patientId(), new HomeBiz.OnLoginListener() {
         @Override
         public void onResponse(ResultModel model) {
             if (model.getResult() == 0) {
                 mNumView.LoadDoctorTeamInfor(model);
             } else {
                 mNumView.onViewFailure(model);
             }
         }

         @Override
         public void onFailure(String e) {
            mNumView.onServerFailure(e);
         }
     });

 }


}
