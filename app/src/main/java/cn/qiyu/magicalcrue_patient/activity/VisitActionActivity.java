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
 * 随访行动
 */

public class VisitActionActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.wb_visit_action)
    WebView mWbVisitAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_action);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.visitAction);
        mWbVisitAction.loadUrl("file:///android_asset/case/patient_html/follow_up_action.html");
        //设置自适应屏幕宽高
        mWbVisitAction.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWbVisitAction.getSettings().setLoadWithOverviewMode(true);
        //可以和js交互
        mWbVisitAction.getSettings().setJavaScriptEnabled(true);

        //在js中调用本地java方法
        mWbVisitAction.addJavascriptInterface(new VisitActionActivity.JsInterface(this), "AndroidWebView");
        mWbVisitAction.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWbVisitAction.loadUrl(url);
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
