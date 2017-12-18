package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;


public class DoctorNoticeDetailActivity extends AppCompatActivity {

    @Bind(R.id.tv_notice_detail_title)
    TextView tvNoticeDetailTitle;
    @Bind(R.id.tv_notice_detail_context)
    TextView tvNoticeDetailContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_notice_detail);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        tvNoticeDetailTitle.setText(intent.getStringExtra("title"));
        tvNoticeDetailContext.setText(intent.getStringExtra("context"));
    }
}
