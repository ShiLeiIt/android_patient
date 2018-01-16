package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * 关于我们
 */

public class AboutUsActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.wb_user_agreement)
    WebView mWbUserAgreement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_agreement);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        mTvTitle.setText(R.string.about_us);

        mWbUserAgreement.loadUrl("file:///android_asset/case/patient_html/patient_about_us.html");

        //设置自适应屏幕宽高
        mWbUserAgreement.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWbUserAgreement.getSettings().setLoadWithOverviewMode(true);
        //可以和js交互
        mWbUserAgreement.getSettings().setJavaScriptEnabled(true);

        //在js中调用本地java方法
        mWbUserAgreement.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        mWbUserAgreement.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWbUserAgreement.loadUrl(url);
                return true;
            }
        });

    }

    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Intent intent = new Intent(mContext, BannerDetailActivity.class);
            JSONObject object = JSON.parseObject(name);
            JSONObject jsonObject = new JSONObject(object);
            String url = jsonObject.getString("url");
            intent.putExtra("url", url);
            mContext.startActivity(intent);
        }

    }
}
