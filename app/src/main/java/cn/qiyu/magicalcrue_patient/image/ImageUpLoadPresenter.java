package cn.qiyu.magicalcrue_patient.image;

import android.widget.Toast;

import java.io.File;

import cn.qiyu.magicalcrue_patient.biz.CityDistrictBiz;
import cn.qiyu.magicalcrue_patient.city.CityDistrictBizImpl;
import cn.qiyu.magicalcrue_patient.city.CityDistrictView;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class ImageUpLoadPresenter {

    private final ImageUpLoadBiz mImageUpLoadBiz;
    private final ImageUpLoadView mImageUpLoadView;

    public ImageUpLoadPresenter(ImageUpLoadView imageUpLoadView) {
        mImageUpLoadBiz = new ImageUpLoadBizImpl();
        mImageUpLoadView = imageUpLoadView;
    }
   public  void getImage(){
       mImageUpLoadView.showProgress();
       mImageUpLoadBiz.getImageUpLoad(mImageUpLoadView.getImageUpLoadFileId(), new ImageUpLoadBiz.OnLoginListener() {
           @Override
           public void onResponse(ImageUpLoadBean model) {
               if (model.getResult() == 0) {
                   mImageUpLoadView.getImageUpLoad(model);
                   mImageUpLoadView.hideProgress();
               } else {
                   mImageUpLoadView.onViewFailure(model);
                   mImageUpLoadView.hideProgress();
               }
           }
           @Override
           public void onFailure(String e) {
                mImageUpLoadView.onServerFailure(e);

               mImageUpLoadView.hideProgress();
           }
       });

   }

}
