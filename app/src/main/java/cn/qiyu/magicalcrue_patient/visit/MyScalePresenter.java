package cn.qiyu.magicalcrue_patient.visit;
import cn.qiyu.magicalcrue_patient.biz.MyScaleBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class MyScalePresenter {
    private MyScaleView mMyScaleView;
    private MyScaleBiz mMyScaleBiz;
    public  MyScalePresenter(MyScaleView myScaleView){
        mMyScaleBiz = new MyScaleBizImpl();
        mMyScaleView = myScaleView;
    }
    public void VisitScaleData(){
        mMyScaleBiz.getMyScaleInfor(mMyScaleView.getPatientUuid(), mMyScaleView.getStatus(),
                mMyScaleView.getPage(), mMyScaleView.getPagecount(), new MyScaleBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mMyScaleView.LoadDate(model);
                        } else {
                            mMyScaleView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mMyScaleView.onServerFailure(e);

                    }
                }

        );
    }


//    public void  HomeLoadNumData(){
//        mHomeBiz.getUserMessageInfo(mNumView.getUserId(), new HomeBiz.OnLoginListener() {
//
//            @Override
//            public void onResponse(ResultModel model) {
//                if (model.getResult() == 0) {
//                    mNumView.LoadDate(model);
//                } else {
//                    mNumView.onViewFailure(model);
//                }
//            }
//            @Override
//            public void onFailure(String e) {
//            mNumView.onServerFailure(e);
//            }
//        });
//    }







}
