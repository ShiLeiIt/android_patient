package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * WebView详情页面
 */

public class BannerDetailActivity extends BaseActivity {
    @Bind(R.id.wv_banner_detail)
    WebView wvBannerDetail;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_detail);
        ButterKnife.bind(this);
        mTvTitle.setText("详情");
        String url = getIntent().getStringExtra("url");
        wvBannerDetail.loadUrl(url);
        //设置自适应屏幕宽高
        wvBannerDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvBannerDetail.getSettings().setLoadWithOverviewMode(true);
        //可以和js交互
        wvBannerDetail.getSettings().setJavaScriptEnabled(true);
        wvBannerDetail.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wvBannerDetail.loadUrl(url);
                return true;
            }
        });
    }
}