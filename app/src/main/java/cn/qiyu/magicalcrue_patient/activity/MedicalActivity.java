package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * 医疗机构
 */
public class MedicalActivity extends BaseActivity {

    @Bind(R.id.iv_medical_back)
    ImageView mIvMedicalBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_medical_back)
    public void onViewClicked() {
        finish();
    }
}
