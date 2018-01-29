package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.picker.DoublePicker;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.view.SwitchButton;
import cn.qiyu.magicalcrue_patient.visit.VisitCreateRemindView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;

/**
 * Created by ShiLei on 2018/1/16.
 * 创建日程提醒
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
    @Bind(R.id.switch_button)
    SwitchButton mSwitchButton;
    @Bind(R.id.tv_recurrence_interval)
    TextView mTvRecurrenceInterval;
    @Bind(R.id.rl_recurrence_interval)
    RelativeLayout mRlRecurrenceInterval;
    @Bind(R.id.tv_recurrence_interval_num)
    TextView mTvRecurrenceIntervalNum;
    private String mRemindTime;
    private String mRepeatNum;
    private String mRepeat;

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
        mSwitchButton.setChecked(true);
        mSwitchButton.isChecked();
        mSwitchButton.toggle();     //switch state
        mSwitchButton.toggle(true);//switch without animation

        mSwitchButton.setShadowEffect(true);//disable shadow effect
        mSwitchButton.setEnabled(true);//disable button
        mSwitchButton.setEnableEffect(true);//disable the switch animation
        if (mSwitchButton.isChecked()) {
            mRlRecurrenceInterval.setVisibility(View.VISIBLE);
        }
        mSwitchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked == false) {
                    mRlRecurrenceInterval.setVisibility(View.INVISIBLE);
                } else {
                    mRlRecurrenceInterval.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    //创建日程提醒
    VisitRemindListPresenter mPresenter = new VisitRemindListPresenter(new VisitCreateRemindView() {
        @Override
        public String getRemindUuid() {
            return "";
        }

        @Override
        public String getEventName() {
            return mTvProjectDetail.getText().toString();
        }

        @Override
        public String getEventRemark() {
            return mIdEditorDetail.getText().toString();
        }

        @Override
        public String getRemindTime() {
            return mTvRemindTime.getText().toString();
        }

        @Override
        public String getRepeatNum() {
            if (mSwitchButton.isChecked()) {
                return mRepeatNum;
            }
            return "0";
        }

        @Override
        public String getRepeatType() {
            if (mSwitchButton.isChecked()) {
                if (mRepeat.equals("月")) {
                    return "1";
                }
                return "2";
            }
            return "0";

        }

        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(AddRemindActivity.this, "patientuuid", "");
//            return "df430ac16590449cba026e34704190f3";
        }

        @Override
        public String getUserRoleType() {
            return "1";
        }

        @Override
        public String getEventReception() {
            return "";
        }

        @Override
        public String getUserStatus() {
            return "1";
        }

        @Override
        public String getReceptionUserStatus() {
            return "0";
        }

        @Override
        public void LoadVisiteCreateRemind(ResultModel<CreateRemindBean> model) {
            Toast.makeText(AddRemindActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {

        }

        @Override
        public void onServerFailure(String e) {

        }
    });

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
//                Log.i("mTvRemindTime===",mRemindTime);
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


    //日程提醒周期选择
    private void tvSelectRemindDate(final TextView tv) {
        final ArrayList<String> hours = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            hours.add(fillZero(i));
        }
        final ArrayList<String> minutes = new ArrayList<>();
        minutes.add("周");
        minutes.add("月");
        DoublePicker picker = new DoublePicker(this, hours, minutes);
        picker.setCanceledOnTouchOutside(true);
        picker.setTopLineColor(getResources().getColor(R.color.vertical_bg));
        picker.setSubmitTextColor(getResources().getColor(R.color.app_black));
        picker.setCancelTextColor(getResources().getColor(R.color.app_black));
        picker.setLineSpaceMultiplier(2.2f);
        picker.setTextSize(16);
        picker.setTitleText("选择重复时间");
        picker.setContentPadding(10, 8);
        picker.setUseWeight(true);
        picker.setFirstLabel("", "");
        picker.setSecondLabel("", "");
        picker.setOnPickListener(new DoublePicker.OnPickListener() {
            @Override
            public void onPicked(int selectedFirstIndex, int selectedSecondIndex) {
                mRepeatNum = hours.get(selectedFirstIndex);
                mRepeat = minutes.get(selectedSecondIndex);
                mTvRecurrenceInterval.setText(minutes.get(selectedSecondIndex));
                mTvRecurrenceIntervalNum.setText(hours.get(selectedFirstIndex));
            }
        });
        picker.show();
    }

    /**
     * 月日时分秒，0-9前补0
     */
    @NonNull
    public String fillZero(int number) {
        return number < 10 ? "" + number : "" + number;
    }


    @OnClick({R.id.tv_remind_time, R.id.rl_recurrence_interval, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //提醒时间选择
            case R.id.tv_remind_time:
                tvSelectDate(mTvRemindTime);
                break;

            //提醒周期选择
            case R.id.rl_recurrence_interval:
                tvSelectRemindDate(mTvRecurrenceInterval);
                break;
            //添加提醒完成
            case R.id.tv_commit:
                if (TextUtils.isEmpty(mTvProjectDetail.getText().toString()) ||
                        TextUtils.isEmpty(mIdEditorDetail.getText().toString())|| mTvRemindTime.getText().toString().equals("")){
                    Toast.makeText(this, "信息填写不完整", Toast.LENGTH_SHORT).show();

                } else {
                    if (mSwitchButton.isChecked()) {
//                        mPresenter.getVisitCreateRemind();
                        if (mTvRecurrenceInterval.getText().toString().equals("")&&mTvRecurrenceIntervalNum.getText().toString().equals("")) {
                            Toast.makeText(this, "信息填写不完整", Toast.LENGTH_SHORT).show();
                        } else {
                            mPresenter.getVisitCreateRemind();
                        }
                    } else {
                        mPresenter.getVisitCreateRemind();
                    }

                }
                break;
        }
    }


}
