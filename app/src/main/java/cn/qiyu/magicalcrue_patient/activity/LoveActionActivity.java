package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * 关爱行动
 */
public class LoveActionActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.wb_love_action)
    WebView mWbLoveAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_action);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        mTvTitle.setText(R.string.loveAction);
        mWbLoveAction.loadUrl("file:///android_asset/case/patient_html/take_care_salon.html");

        //设置自适应屏幕宽高
        mWbLoveAction.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWbLoveAction.getSettings().setLoadWithOverviewMode(true);
        //可以和js交互
        mWbLoveAction.getSettings().setJavaScriptEnabled(true);

        //在js中调用本地java方法
        mWbLoveAction.addJavascriptInterface(new LoveActionActivity.JsInterface(this), "AndroidWebView");
        mWbLoveAction.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWbLoveAction.loadUrl(url);
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
            intent.putExtra("url", name);
            mContext.startActivity(intent);
        }

    }

}
