package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.information.InformationDoNoRdView;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
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
    private String mMessageUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_notice_detail);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        mMessageUuid = intent.getStringExtra("messageUuid");
        tvNoticeDetailTitle.setText(intent.getStringExtra("title"));
        tvNoticeDetailContext.setText(intent.getStringExtra("context"));
        mInformationPresenter.getDoctorNoticeRead();
    }

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationDoNoRdView() {
        @Override
        public String getUserUuid() {

            return (String) PreUtils.getParam(DoctorNoticeDetailActivity.this,"uuid","0");
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
