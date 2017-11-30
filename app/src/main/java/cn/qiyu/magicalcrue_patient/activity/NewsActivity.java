package cn.qiyu.magicalcrue_patient.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by ShiLei on 2017/11/30.
 * 随访中对话
 */

public class NewsActivity extends Activity {
    @Bind(R.id.iv_userinfor_back)
    ImageView mIvUserinforBack;
    @Bind(R.id.tv_question)
    TextView mTvQuestion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_userinfor_back, R.id.tv_question})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_userinfor_back:
                finish();
                break;
            case R.id.tv_question:
                break;
        }
    }
}
