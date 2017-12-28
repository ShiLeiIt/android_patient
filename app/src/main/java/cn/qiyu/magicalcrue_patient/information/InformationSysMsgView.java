package cn.qiyu.magicalcrue_patient.information;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/27.
 */

public interface InformationSysMsgView extends BaseView {
    String getPage();
    String getPagecount();
    void getSystemMessageList(ResultModel<List<InfoUserSystemMsgListBean>> model);
    String getUserUuid();



}
