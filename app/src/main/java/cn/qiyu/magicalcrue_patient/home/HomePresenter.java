package cn.qiyu.magicalcrue_patient.home;

import android.widget.Toast;

import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;

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
            public void onResponse(HomeNumBean model) {
                if (model.getResult() == 0) {
                    mNumView.LoadDate(model);
                } else {
                    mNumView.LoadDate(model);
                }
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }
}
