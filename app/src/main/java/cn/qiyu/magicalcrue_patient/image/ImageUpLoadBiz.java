package cn.qiyu.magicalcrue_patient.image;


import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import okhttp3.RequestBody;
/**
 * Created by ShiLei on 2017/11/22.
 */

public interface ImageUpLoadBiz {
    void getImageUpLoad(RequestBody imgs, OnLoginListener  onLoginListener);
    interface OnLoginListener {
        /**
         * 服务器响应
         *
         * @param model
         */
        void onResponse(ImageUpLoadBean model);

        /**
         * 服务器未响应
         *
         * @param e
         */
        void onFailure(String e);
    }
}
