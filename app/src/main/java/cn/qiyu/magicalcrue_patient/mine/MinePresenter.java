package cn.qiyu.magicalcrue_patient.mine;

import cn.qiyu.magicalcrue_patient.biz.MineBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/27.
 */

public class MinePresenter {
    private MineInforView mMineInforView;
    private MineBiz mMineBiz;

    public MinePresenter(MineInforView MineInforView) {
        mMineBiz = new MineBizImpl();
        mMineInforView = MineInforView;
    }

    public  void  getUserBasicInfor(){
        mMineBiz.getUserInfo(mMineInforView.getUserUuid(), new MineBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mMineInforView.getUserBasicInfor(model);
                } else {
                    mMineInforView.onViewFailure(model);
                }
            }
            @Override
            public void onFailure(String e) {
                mMineInforView.onServerFailure(e);
            }
        });
    }


    public  void getPatientBasicInfor(){
        mMineBiz.getPatientInfor(mMineInforView.getPatientBasicUuid(), new MineBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mMineInforView.getPatientBasicInfor(model);
                        } else {
                            mMineInforView.onViewFailure(model);
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mMineInforView.onServerFailure(e);
                    }
                }
        );

    }



//        public void  HomeLoadNumData(){
//            mHomeBiz.getUserMessageInfo(mNumView.getUserId(), new HomeBiz.OnLoginListener() {
//
//                @Override
//                public void onResponse(ResultModel model) {
//                    if (model.getResult() == 0) {
//                        mNumView.LoadDate(model);
//                    } else {
//                        mNumView.onViewFailure(model);
//                    }
//                }
//                @Override
//                public void onFailure(String e) {
//                    mNumView.onServerFailure(e);
//                }
//            });
//        }


}
