package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * 患教课程
 */

public class CourseActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        mTvTitle.setText(R.string.course);
    }


}
