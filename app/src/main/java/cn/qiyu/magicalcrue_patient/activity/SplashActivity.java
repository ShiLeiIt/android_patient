package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VersionUpdateBean;
import cn.qiyu.magicalcrue_patient.register_login.AppVersionPresenter;
import cn.qiyu.magicalcrue_patient.register_login.AppVersionView;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.Utils;

/**
 * Created by ShiLei on 2018/1/20.
 * 启动页面展示
 */

public class SplashActivity extends BaseActivity {
    private String mVersionName;
    private String mVersionNumber;
    private static final int INTO_VERSION_ENSURE=0x0001;
    private String mAppUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        initData();
    }

    private void init() {
        try {
            mVersionName = SplashActivity.this.getPackageManager().getPackageInfo(
                    SplashActivity.this.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void initData() {
        mAppVersionPresenter.getAppVersionIsUpdate();

    }

    AppVersionPresenter mAppVersionPresenter = new AppVersionPresenter(new AppVersionView() {
        @Override
        public String getCode() {
            return "patient";
        }

        @Override
        public String getPlatform() {
            return "1";
        }

        @Override
        public String getChannel() {
//            if (Utils.isDebug(SplashActivity.this)) {
//                Toast.makeText(SplashActivity.this, "Debug", Toast.LENGTH_SHORT).show();
//                return "0";
//            }
//            Toast.makeText(SplashActivity.this, "release", Toast.LENGTH_SHORT).show();
            return "1";
        }

        @Override
        public String getCurrentVersion() {
//            return "2.0-2018011120";
            return mVersionName;
        }

        @Override
        public void getAppVersionIsUpdate(ResultModel<VersionUpdateBean> model) {

            if (null != model.getData()) {
                mAppUrl = model.getData().getApp_url();
                Intent intent = new Intent(SplashActivity.this, AppLatestVersionActivity.class);
                intent.putExtra("versionModel", model.getData());
                startActivityForResult(intent,INTO_VERSION_ENSURE);
            } else {
                String token = (String) PreUtils.getParam(SplashActivity.this, GlobalConstants.TOKEN, "0");
                if (token.equals("") || token.equals("0")) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(SplashActivity.this, "" + model.getErrorCode(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(SplashActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case INTO_VERSION_ENSURE:
                    String type= data.getStringExtra("type");
                    switch (type){
                        case "yes":
                            Intent intent = new Intent();
                            intent.setData(Uri.parse(mAppUrl));
                            intent.setAction(Intent.ACTION_VIEW);
                            startActivity(intent);
                            finish();
                            break;
                        case  "no":
                            String token = (String) PreUtils.getParam(SplashActivity.this, GlobalConstants.TOKEN, "0");
                            if (token.equals("") || token.equals("0")) {
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                finish();
                            } else {
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                finish();
                            }

                            break;
                    }
                    break;
            }

        }
    }
}
