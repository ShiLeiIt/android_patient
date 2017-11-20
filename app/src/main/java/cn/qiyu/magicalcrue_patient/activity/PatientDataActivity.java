package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;

/**
 * 患者资料信息页面
 */
public class PatientDataActivity extends AppCompatActivity {

    @Bind(R.id.iv_patient_back)
    ImageView mIvPatientBack;
    @Bind(R.id.tv_save_userinfor)
    TextView mTvSaveUserinfor;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.iv_name_arrows)
    ImageView mIvNameArrows;
    @Bind(R.id.tv_real_name)
    TextView mTvRealName;
    @Bind(R.id.tv_gender)
    TextView mTvGender;
    @Bind(R.id.iv_girl)
    ImageView mIvGirl;
    @Bind(R.id.tv_girl_s)
    TextView mTvGirlS;
    @Bind(R.id.iv_boy)
    ImageView mIvBoy;
    @Bind(R.id.tv_Date)
    TextView mTvDate;
    @Bind(R.id.tv_select_Date)
    TextView mTvSelectDate;
    @Bind(R.id.tv_identity)
    TextView mTvIdentity;
    @Bind(R.id.tv_eighteen)
    EditText mTvEighteen;
    @Bind(R.id.tv_phone)
    TextView mTvPhone;
    @Bind(R.id.tv_flowers)
    EditText mTvFlowers;
    @Bind(R.id.tv_citiy)
    TextView mTvCitiy;
    @Bind(R.id.tv_select_citiy)
    TextView mTvSelectCitiy;
    @Bind(R.id.tv_actions)
    TextView mTvActions;
    @Bind(R.id.iv_doctor_name_arrows)
    ImageView mIvDoctorNameArrows;
    @Bind(R.id.et_actions_name)
    EditText mEtActionsName;
    @Bind(R.id.tv_first_visit)
    TextView mTvFirstVisit;
    @Bind(R.id.iv_first_arrows)
    ImageView mIvFirstArrows;
    @Bind(R.id.tv_first_visit_time)
    TextView mTvFirstVisitTime;
    @Bind(R.id.tv_diseases_t)
    TextView mTvDiseasesT;
    @Bind(R.id.iv_diseases_arrows)
    ImageView mIvDiseasesArrows;
    @Bind(R.id.tv_diseases)
    TextView mTvDiseases;
    @Bind(R.id.tv_patient_relation)
    TextView mTvPatientRelation;
    @Bind(R.id.iv_relation_arrows)
    ImageView mIvRelationArrows;
    @Bind(R.id.rl_patient_relation)
    RelativeLayout mRlPatientRelation;
    @Bind(R.id.tv_relation_name)
    TextView mTvRelationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_da);
        ButterKnife.bind(this);
        mTvRelationName.setText(getIntent().getStringExtra("name"));

    }


    @OnClick({R.id.iv_patient_back, R.id.tv_save_userinfor, R.id.iv_name_arrows, R.id.tv_real_name, R.id.iv_girl,
            R.id.iv_boy, R.id.tv_select_Date, R.id.tv_eighteen, R.id.tv_flowers, R.id.tv_select_citiy,
            R.id.iv_doctor_name_arrows, R.id.et_actions_name, R.id.iv_first_arrows, R.id.tv_first_visit_time, R.id.rl_patient_relation,
            R.id.iv_diseases_arrows, R.id.tv_diseases})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_patient_back:
                break;
            case R.id.tv_save_userinfor:
                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_real_name:
                break;
            case R.id.iv_girl:
                mIvGirl.setImageResource(R.drawable.check_box_select);
                mIvBoy.setImageResource(R.drawable.check_box_normal);
                break;
            case R.id.iv_boy:
                mIvBoy.setImageResource(R.drawable.check_box_select);
                mIvGirl.setImageResource(R.drawable.check_box_normal);
                break;
            case R.id.tv_select_Date:
                tvSelectDate(mTvSelectDate);
                break;
            case R.id.tv_eighteen:
                break;
            case R.id.tv_flowers:
                break;
            case R.id.tv_select_citiy:
                tvSelectCity();
                break;
            case R.id.iv_doctor_name_arrows:
                break;
            case R.id.et_actions_name:
                break;
            case R.id.iv_first_arrows:
                break;
            case R.id.tv_first_visit_time:
                tvSelectDate(mTvFirstVisitTime);
                break;
            case R.id.iv_diseases_arrows:
                break;
            case R.id.tv_diseases:
                break;
            case R.id.rl_patient_relation:
                startActivity(new Intent(PatientDataActivity.this, PatientRelationListActivity.class));
                break;

        }
    }

    //城市的选择
    private void tvSelectCity() {
        AddressPickTask task = new AddressPickTask(this);
        task.setHideProvince(false);
        task.setHideCounty(false);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
//                showToast("数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                if (county == null) {
                    mTvSelectCitiy.setText(province.getAreaName() + "-" + city.getAreaName());
//                    showToast(province.getAreaName() + "-" + city.getAreaName());
                } else {
                    mTvSelectCitiy.setText(province.getAreaName() + "-" + city.getAreaName() + "-" + county.getAreaName());
//                    showToast(province.getAreaName() + "-" + city.getAreaName() + "-" + county.getAreaName());
                }
            }
        });
        task.execute("北京市", "北京市", "东城区");
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
//                        showToast(year + "-" + month + "-" + day);
                tv.setText(year + "-" + month + "-" + day);
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

    @OnClick(R.id.tv_relation_name)
    public void onViewClicked() {
    }
}
