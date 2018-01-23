package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.VersionUpdateBean;
import cn.qiyu.magicalcrue_patient.utils.ActivityManagerTool;

/**
 * App版本升级Dialog
 * Created by ShiLei on 2018/1/23.
 */

public class AppLatestVersionActivity extends BaseActivity {

    @Bind(R.id.tv_version_next)
    TextView mTvVersionNext;
    @Bind(R.id.tv_version_ensure)
    TextView mTvVersionEnsure;
    @Bind(R.id.tv_version_title)
    TextView mTvVersionTitle;
    @Bind(R.id.tv_version_context)
    TextView mTvVersionContext;
    @Bind(R.id.view_line)
    View mViewLine;
    private VersionUpdateBean mVersionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_latest_version);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mVersionModel = (VersionUpdateBean) getIntent().getSerializableExtra("versionModel");
        mTvVersionTitle.setText(mVersionModel.getRelease_title());
        mTvVersionContext.setText(mVersionModel.getRelease_notes());
        if (mVersionModel.isForce_update()) {
            mTvVersionNext.setVisibility(View.GONE);
            mViewLine.setVisibility(View.GONE);
        } else
            mTvVersionNext.setVisibility(View.VISIBLE);

    }

    @OnClick({R.id.tv_version_next, R.id.tv_version_ensure})
    public void onViewClicked(View view) {
        Intent intent1 = new Intent(AppLatestVersionActivity.this, SplashActivity.class);
        switch (view.getId()) {
            case R.id.tv_version_next:
                intent1.putExtra("type", "no");
                setResult(RESULT_OK, intent1);
                finish();
                break;
            case R.id.tv_version_ensure:
                intent1.putExtra("type", "yes");
                setResult(RESULT_OK, intent1);
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerTool.getActivityManager().finish(AppLatestVersionActivity.this);
    }
}
