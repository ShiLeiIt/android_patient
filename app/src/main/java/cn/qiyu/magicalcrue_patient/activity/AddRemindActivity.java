package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;

/**
 * Created by ShiLei on 2018/1/16.
 */

public class AddRemindActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    @Bind(R.id.tv_project)
    TextView mTvProject;
    @Bind(R.id.tv_project_detail)
    EditText mTvProjectDetail;
    @Bind(R.id.id_editor_detail)
    EditText mIdEditorDetail;
    @Bind(R.id.tv_remind_week_time)
    TextView mTvRemindWeekTime;
    @Bind(R.id.tv_remind_time)
    TextView mTvRemindTime;
    private String mRemindTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remind);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvCommit.setVisibility(View.VISIBLE);
        mTvCommit.setText(R.string.finish);
        mTvCommit.setTextColor(getResources().getColor(R.color.app_userInfor));

        mTvTitle.setText(R.string.add);
    }

    //日期的选择
    private void tvSelectDate(final TextView tv) {
        final DatePicker picker = new DatePicker(this);
        picker.setCanLoop(false);
        picker.setWheelModeEnable(true);
        picker.setTopPadding(15);
        picker.setRangeStart(1950, 1, 1);
        picker.setRangeEnd(2050, 1, 11);
        picker.setSelectedItem(2017, 10, 14);
        picker.setWeightEnable(true);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {

                tv.setText(year + "-" + month + "-" + day);
                if (!TextUtils.isEmpty(mTvRemindTime.getText())) {
                    mRemindTime = mTvRemindTime.getText().toString();
                    mTvRemindWeekTime.setText(TimeUtils.getWeekStr(mRemindTime));
                }
                Log.i("mTvRemindTime===",mRemindTime);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }

    @OnClick({R.id.tv_remind_week_time, R.id.tv_remind_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_remind_week_time:

                break;
            case R.id.tv_remind_time:
                tvSelectDate(mTvRemindTime);


//                if (!mTvRemindTime.equals("")) {
//                    mTvRemindWeekTime.setText(TimeUtils.getWeekStr(mTvRemindTime.toString()));
//                }

                break;
        }
    }
}
