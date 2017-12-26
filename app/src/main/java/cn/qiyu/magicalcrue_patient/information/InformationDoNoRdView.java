package cn.qiyu.magicalcrue_patient.information;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/26.
 * 医生公告列表已读
 */

public interface InformationDoNoRdView extends BaseView {

    String getUserUuid();
    String getMessageUuid();
    void getDoctorNoticeRead(ResultModel model);

}
