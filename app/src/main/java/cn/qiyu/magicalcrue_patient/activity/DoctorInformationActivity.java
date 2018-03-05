package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.model.WebViewBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;


public class DoctorInformationActivity extends AppCompatActivity {


    @Bind(R.id.wv_user_information)
    WebView wvUserInformation;
    final WebViewBean wu = new WebViewBean();
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    private String jsonUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_information);
        ButterKnife.bind(this);
        mTvTitle.setText("个人主页");
        //设置自适应屏幕宽高
        wvUserInformation.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvUserInformation.getSettings().setLoadWithOverviewMode(true);
        //让WebView支持JavaScript
        wvUserInformation.getSettings().setJavaScriptEnabled(true);
        //wu 为对象
        wu.setBaseUrl(ApiService.BASE_URL);
        wu.setTempDoctorUUID(getIntent().getStringExtra(GlobalConstants.DOCTOR_UUID));
        //将对象序列化成json字符串
        jsonUrl = JSONArray.toJSONString(wu);

        wvUserInformation.loadUrl("file:///android_asset/case/common_html/doctor_home.html");

        //添加客户端支持

        wvUserInformation.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wvUserInformation.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:passMobileData(" + jsonUrl + ")");
            }
        });
    }
}
