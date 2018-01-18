package cn.qiyu.magicalcrue_patient.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_detail);
        ButterKnife.bind(this);
        mTvTitle.setText("详情");
        String url = getIntent().getStringExtra("url");
        Log.i("url====",url);
        wvBannerDetail.loadUrl(url);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            wvBannerDetail.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
        //设置自适应屏幕宽高
        wvBannerDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        wvBannerDetail.getSettings().setLoadWithOverviewMode(true);
        wvBannerDetail.getSettings().setUseWideViewPort(true);


        //可以和js交互
        wvBannerDetail.getSettings().setJavaScriptEnabled(true);
        wvBannerDetail.setWebViewClient(new MyWebViewClient());

    }
    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        wvBannerDetail.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }

    @Override
    public void onPause() {
        super.onPause();
        wvBannerDetail.onPause();
        wvBannerDetail.pauseTimers();
    }

    @Override
    public void onResume() {
        super.onResume();
        wvBannerDetail.resumeTimers();
        wvBannerDetail.onResume();
    }

    @Override
    protected void onDestroy() {
        wvBannerDetail.destroy();
        wvBannerDetail = null;
        super.onDestroy();
    }
}
