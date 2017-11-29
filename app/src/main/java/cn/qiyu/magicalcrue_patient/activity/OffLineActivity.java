package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;

/**
 * 线下沙龙
 */

public class OffLineActivity extends AppCompatActivity {

    @Bind(R.id.iv_offline_back)
    ImageView mIvOfflineBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_line);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_offline_back)
    public void onViewClicked() {
        finish();
    }
}
