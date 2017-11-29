package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;

/**
 * 患教课程
 */

public class CourseActivity extends AppCompatActivity {

    @Bind(R.id.iv_course_back)
    ImageView mIvCourseBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_course_back)
    public void onViewClicked() {
        finish();
    }
}
