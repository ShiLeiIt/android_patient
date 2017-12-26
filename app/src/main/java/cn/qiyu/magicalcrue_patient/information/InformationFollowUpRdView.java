package cn.qiyu.magicalcrue_patient.information;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/26.
 * 消息随访对话已读
 */

public interface InformationFollowUpRdView extends BaseView {

    String getUserUuid();
    void LoadFollowUpMsgRead(ResultModel model);

}
