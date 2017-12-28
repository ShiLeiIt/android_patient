package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.information.InformationDoNoRdView;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationSysMsgRdView;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * 医生公告详情
 */


public class DoctorNoticeDetailActivity extends AppCompatActivity {

    @Bind(R.id.tv_notice_detail_title)
    TextView tvNoticeDetailTitle;
    @Bind(R.id.tv_notice_detail_context)
    TextView tvNoticeDetailContext;
    @Bind(R.id.tv_title_details)
    TextView mTvTitleDetails;
    private String mMessageUuid;
    private String mIsSystemMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_notice_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mIsSystemMsg = intent.getStringExtra("isSystemMsg");
        mMessageUuid = intent.getStringExtra("messageUuid");
        tvNoticeDetailTitle.setText(intent.getStringExtra("title"));
        tvNoticeDetailContext.setText(intent.getStringExtra("context"));
        if (mIsSystemMsg.equals("isSystemMsg")) {
            mTvTitleDetails.setText(R.string.systemMessagesDetails);

            mPresenter.getSystemMsgRead();

        } else {
            mTvTitleDetails.setText(R.string.doctorNoticeDetails);
            mInformationPresenter.getDoctorNoticeRead();
        }



    }
    //系统消息已读
    InformationPresenter mPresenter = new InformationPresenter(new InformationSysMsgRdView() {
        @Override
        public String getMessageId() {
            return mMessageUuid;
        }

        @Override
        public void getSystemMessageRead(ResultModel<InfoUserSystemMsgListBean> model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {

        }

        @Override
        public void onServerFailure(String e) {

        }
    });

    //医生公告详情已读
    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationDoNoRdView() {
        @Override
        public String getUserUuid() {

            return (String) PreUtils.getParam(DoctorNoticeDetailActivity.this, "uuid", "0");
        }

        @Override
        public String getMessageUuid() {
            return mMessageUuid;
        }

        @Override
        public void getDoctorNoticeRead(ResultModel model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
        }

        @Override
        public void onServerFailure(String e) {

        }
    });
}
