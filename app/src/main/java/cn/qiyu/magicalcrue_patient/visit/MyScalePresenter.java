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
    //量表
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
    //量表详情
    public  void VisitScaleDetailsData(){
        mMyScaleBiz.getScaleDetailsInfor(mMyScaleView.paperId(), mMyScaleView.paperUserId(), mMyScaleView.userId(), new MyScaleBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mMyScaleView.LoadScaleDetailsData(model);
                } else {
                    mMyScaleView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mMyScaleView.onServerFailure(e);
            }
        });
    }








}
