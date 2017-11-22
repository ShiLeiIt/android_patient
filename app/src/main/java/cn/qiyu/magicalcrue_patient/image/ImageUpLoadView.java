package cn.qiyu.magicalcrue_patient.image;

import java.io.File;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.base.ImageUpLoadBaseView;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import okhttp3.RequestBody;


/**
 * Created by ShiLei on 2017/11/22.
 */

public interface ImageUpLoadView extends ImageUpLoadBaseView {
    RequestBody getImageUpLoadFile();

    void getImageUpLoad(ImageUpLoadBean imageUpLoadBean);
}
