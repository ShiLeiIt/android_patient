package cn.qiyu.magicalcrue_patient.image;

import java.io.File;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import okhttp3.RequestBody;


/**
 * Created by ShiLei on 2017/11/22.
 */

public interface ImageUpLoadView  {

    RequestBody getImageUpLoadFileId();
    void getImageUpLoad(ImageUpLoadBean imageUpLoadBean);

    void showProgress();

    void hideProgress();

    /**
     * 服务器返回的不是 200
     * <p>
     * 服务器返回  200 400 403 405 500
     *
     * @param model
     */
    void onViewFailure(ImageUpLoadBean model);

    /**
     * 服务断开
     *
     * @param e
     */
    void onServerFailure(String e);
}
