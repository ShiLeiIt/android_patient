package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;

/**
 * 全部服务
 */
public class AllServeActivity extends AppCompatActivity {

    @Bind(R.id.iv_allserve_back)
    ImageView mIvAllserveBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_serve);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_allserve_back)
    public void onViewClicked() {
        finish();
    }
}
