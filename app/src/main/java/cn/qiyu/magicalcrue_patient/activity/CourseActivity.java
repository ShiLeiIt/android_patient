package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.utils.Utils;

/**
 * 患教课程
 */

public class CourseActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.wb_course)
    WebView wvEducation;
    private static final String APP_CACAHE_DIRNAME = "/webcache";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        mTvTitle.setText(R.string.course);

        wvEducation.loadUrl("file:///android_asset/case/common_html/teaching_materials.html");

        //设置自适应屏幕宽高
        wvEducation.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvEducation.getSettings().setLoadWithOverviewMode(true);
        //可以和js交互
        wvEducation.getSettings().setJavaScriptEnabled(true);



        //在js中调用本地java方法
        wvEducation.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        wvEducation.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wvEducation.loadUrl(url);
                return true;
            }
        });
//        wvEducation.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
////         支持多窗口
//        wvEducation.getSettings().setSupportMultipleWindows(true);
////         开启 DOM storage API 功能
//        wvEducation.getSettings().setDomStorageEnabled(true);
////         开启 Application Caches 功能
//        wvEducation.getSettings().setAppCacheEnabled(true);
//        String cacheDirPath = getFilesDir().getAbsolutePath()+APP_CACAHE_DIRNAME;
//        wvEducation.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);//设置 缓存模式
////        设置数据库缓存路径
//        wvEducation.getSettings().setDatabasePath(cacheDirPath);
////        设置  Application Caches 缓存目录
//        wvEducation.getSettings().setAppCachePath(cacheDirPath);
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
