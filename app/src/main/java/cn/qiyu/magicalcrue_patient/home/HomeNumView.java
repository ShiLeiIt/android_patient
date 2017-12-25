package cn.qiyu.magicalcrue_patient.home;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public interface HomeNumView extends BaseView {
     String  getUserId();
    void LoadDate(ResultModel<HomeNumBean> numBean);

    //二维码
    String patientUuid();
    String DoctorUuid();
    void getDoctorQRcode(ResultModel model);

    //获取医生团队信息

    void LoadDoctorTeamInfor(ResultModel<DoctorTeamBean> model);

    //获取首页Banner
    String getType();
    void LoadHomeBanner(ResultModel<List<HomeBannerBean>> model);

}
