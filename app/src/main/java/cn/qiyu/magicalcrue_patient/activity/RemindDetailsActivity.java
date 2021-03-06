package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
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
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.picker.DoublePicker;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.view.SwitchButton;
import cn.qiyu.magicalcrue_patient.visit.VisitCreateRemindView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindDetailsView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;

/**
 * Created by ShiLei on 2018/1/18.
 * 日程提醒详情
 */

public class RemindDetailsActivity extends BaseActivity {
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
    private String mRemindUuid;
    private String mRemindTimeWeek;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remind);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        mSwitchButton.setChecked(true);
        mSwitchButton.isChecked();
        mSwitchButton.toggle();     //switch state
        mSwitchButton.toggle(true);//switch without animation

        mSwitchButton.setShadowEffect(true);//disable shadow effect
        mSwitchButton.setEnabled(true);//disable button
        mSwitchButton.setEnableEffect(true);//disable the switch animation
        Intent intent = getIntent();
        mRemindUuid = intent.getStringExtra("remindUuid");
        mRemindTimeWeek = intent.getStringExtra("remindTimeWeek");
        //判断如果是从哪个进入详情页面

        String mFromFollowUp = intent.getStringExtra("fromFollowUp");
        if (mFromFollowUp.equals("0")) {
            //mFromFollowUp为0的时候是从随访对话进入
            mTvCommit.setVisibility(View.GONE);
        } else {
            //mFromFollowUp为1的时候从提醒界面进入
            mTvCommit.setVisibility(View.VISIBLE);
            mTvCommit.setText(R.string.modification);
            mTvCommit.setTextColor(getResources().getColor(R.color.app_userInfor));
        }

        mTvTitle.setText(R.string.details);
        mTvRemindWeekTime.setText(mRemindTimeWeek);

//
//        if (mSwitchButton.isChecked()) {
//            mRlRecurrenceInterval.setVisibility(View.VISIBLE);
//        }

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
        mDetailsPresenter.getVisitRemindDetails();
    }

    VisitRemindListPresenter mDetailsPresenter = new VisitRemindListPresenter(new VisitRemindDetailsView() {
        @Override
        public String getRemindUuid() {
            return mRemindUuid;
        }

        @Override
        public void LoadVisiteRemindDetails(ResultModel<CreateRemindBean> model) {

            mTvProjectDetail.setText(model.getData().getEvent_name());
            mIdEditorDetail.setText(model.getData().getEvent_detail());
            mTvRemindTime.setText(model.getData().getEvent_time() );
            String repeat_type = model.getData().getRepeat_type();
            String repeat_num = model.getData().getRepeat_num();
            if (repeat_num.equals("0") && repeat_type.equals("0")) {
                mSwitchButton.setChecked(false);
                mRlRecurrenceInterval.setVisibility(View.INVISIBLE);
            } else {
                mSwitchButton.setChecked(true);
                mRlRecurrenceInterval.setVisibility(View.VISIBLE);
                mTvRecurrenceIntervalNum.setText(model.getData().getRepeat_num());
                if (model.getData().getRepeat_type().equals("1")) {
                    mTvRecurrenceInterval.setText("月");
                    mRepeat = "月";
                } else {
                    mTvRecurrenceInterval.setText("周");
                    mRepeat = "周";
                }

            }

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


    //修改日程提醒
    VisitRemindListPresenter mPresenter = new VisitRemindListPresenter(new VisitCreateRemindView() {
        @Override
        public String getRemindUuid() {
            return mRemindUuid;
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
                if (!mRepeat.equals("")) {
                    if (mRepeat.equals("月")) {
                        return "1";
                    }
                    return "2";
                }
            }
            return "0";

        }

        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(RemindDetailsActivity.this, GlobalConstants.PATIENT_UUID, "");
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
            Toast.makeText(RemindDetailsActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
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
            //修改提醒完成
            case R.id.tv_commit:
                if (TextUtils.isEmpty(mTvProjectDetail.getText().toString()) ||
                        TextUtils.isEmpty(mIdEditorDetail.getText().toString()) ||
                        mTvRemindTime.getText().toString().equals("2018-1-1")) {
                    Toast.makeText(this, "信息填写不完整", Toast.LENGTH_SHORT).show();
                } else {
                    if (mSwitchButton.isChecked()) {
                        if (mTvRecurrenceInterval.getText().toString().equals("")&&mTvRecurrenceIntervalNum.getText().toString().equals("")) {
                            Toast.makeText(this, "信息填写不完整", Toast.LENGTH_SHORT).show();
                        } else {
                            mPresenter.getVisitCreateRemind();
                        }
                    } else {
                        mPresenter.getVisitCreateRemind();
                    }

                }
//                mPresenter.getVisitCreateRemind();
                break;
        }
    }


}
