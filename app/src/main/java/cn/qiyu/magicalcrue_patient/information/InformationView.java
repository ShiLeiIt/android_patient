package cn.qiyu.magicalcrue_patient.information;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.InfoDoctorNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 */

public interface InformationView extends BaseView {
    String getDoctorUuid();
    String getPage();
    String getPagecount();
    void getDoctorNoticeList(ResultModel<List<InfoDoctorNoticeListBean>> model);

}
