package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.PatientInforSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.patientinfor.PatientInforPresenter;
import cn.qiyu.magicalcrue_patient.patientinfor.PatientInforView;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * 患者资料信息页面
 */
public class MinePatientDataActivity extends AppCompatActivity {

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
    private String mUserId;
    private String mAddressname;
    private String mAddresscode;
    private String mRelationName;
    private String mDiseaseName;
    private String mRelationNameBianma;
    private String mUuid;
    private String mDiseaseId;
    private PatientInfor mPatientInfor;
    private String mVisitFragment;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_da);
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);


        init();

    }


    private void init() {
        mIvGirl.setTag(0);
        mIntent = getIntent();
        //从随访页面进来
        mPatientInfor = (PatientInfor) mIntent.getSerializableExtra("patientInfor");
        mUserId = (String) PreUtils.getParam(MinePatientDataActivity.this, "userid", "0");
        //mUuid 是用户 uuid
        mUuid = (String) PreUtils.getParam(MinePatientDataActivity.this, "uuid", "0");
        //患者名字
        mTvRealName.setText(mPatientInfor.getName());
        //性别
        String sex = mPatientInfor.getSex();
        if (sex.equals("0")) {
            mIvBoy.setImageResource(R.drawable.check_box_select);
            mIvGirl.setImageResource(R.drawable.check_box_normal);
        } else {
            mIvGirl.setImageResource(R.drawable.check_box_select);
            mIvBoy.setImageResource(R.drawable.check_box_normal);
        }
        //出生日期
        mTvSelectDate.setText(mPatientInfor.getBirthday());
        mTvEighteen.setText(mPatientInfor.getIDcardNo());
        mTvFlowers.setText(mPatientInfor.getUserMobile());
        mTvSelectCitiy.setText(mPatientInfor.getNativeName());

        mTvRelationName.setText(mPatientInfor.getRelationshipName());
        mEtActionsName.setText(mPatientInfor.getAttending_doctor());
        mTvFirstVisitTime.setText(mPatientInfor.getFirstVisitTime());
        mTvDiseases.setText(mPatientInfor.getDisease_name());
    }


    PatientInforPresenter mPatientInforPresenter = new PatientInforPresenter(new PatientInforView() {
        @Override
        public String getUserId() {
//            Toast.makeText(PatientDataActivity.this, "usrid" + mUserId, Toast.LENGTH_SHORT).show();
            return mUuid;
        }

        @Override
        public String getPatientName() {
            return mTvRealName.getText().toString();
        }

        @Override
        public String getSex() {
            if (((Integer) (mIvGirl.getTag())) == 1) {
                return "1";
            }
            return "0";
        }

        @Override
        public String getBirthday() {
            return mTvSelectDate.getText().toString();
        }

        @Override
        public String getIdCardNO() {
            return mTvEighteen.getText().toString();
        }

        @Override
        public String getMobile() {
            return mTvFlowers.getText().toString();
        }

        @Override
        public String getNative_place_cd() {
            if (null == mAddresscode)
                return mPatientInfor.getNative_place_cd();
            return mAddresscode;
        }

        @Override
        public String getAttending_doctor() {
            return mEtActionsName.getText().toString();
        }

        @Override
        public String getFirstVisitTime() {
            return mTvSelectDate.getText().toString();
        }

        @Override
        public String getRelationship() {
            return mRelationNameBianma;
        }

        @Override
        public String getDisease_id() {
            if (null == mDiseaseId) {
                return mPatientInfor.getDisease_id();
            }
            return mDiseaseId;
        }

        @Override
        public String getAppFirstVisitTime() {
            return mTvSelectDate.getText().toString();
        }

        @Override
        public void getPatientInfor(ResultModel<PatientInforSaveBean> rlBean) {
            PreUtils.setParam(MinePatientDataActivity.this, "patientuuid", rlBean.getData().getUuid());
            PreUtils.setParam(MinePatientDataActivity.this, "patientName", rlBean.getData().getName());
            PreUtils.setParam(MinePatientDataActivity.this, "patientMobile", rlBean.getData().getMobile());
            PreUtils.setParam(MinePatientDataActivity.this, "userperfect", "3");

                finish();


            Log.i("Patientuuid------", rlBean.getData().getUuid());
            Log.i("Useruuid------", mUuid);
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


    @OnClick({R.id.iv_patient_back, R.id.tv_save_userinfor, R.id.iv_name_arrows, R.id.tv_real_name, R.id.iv_girl,
            R.id.iv_boy, R.id.tv_select_Date, R.id.tv_eighteen, R.id.tv_flowers, R.id.tv_select_citiy,
            R.id.iv_relation_arrows,
            R.id.iv_doctor_name_arrows, R.id.et_actions_name, R.id.iv_first_arrows, R.id.tv_first_visit_time, R.id.rl_patient_relation,
            R.id.iv_diseases_arrows, R.id.tv_diseases})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_patient_back:
                onBackPressed();
                break;
            case R.id.tv_save_userinfor:

                mPatientInforPresenter.getPatientInforCom();

                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_real_name:
                break;
            case R.id.iv_girl:
                mIvGirl.setTag(1);
                mIvBoy.setTag(0);
                mIvGirl.setImageResource(R.drawable.check_box_select);
                mIvBoy.setImageResource(R.drawable.check_box_normal);
                break;
            case R.id.iv_boy:
                mIvBoy.setTag(1);
                mIvGirl.setTag(0);
                mIvBoy.setImageResource(R.drawable.check_box_select);
                mIvGirl.setImageResource(R.drawable.check_box_normal);
                break;
            case R.id.tv_select_Date:
                tvSelectDate(mTvSelectDate);
                break;
            case R.id.iv_relation_arrows:
                Intent intent = new Intent(MinePatientDataActivity.this, PatientRelationListActivity.class);
                intent.putExtra("isreleation", "0");
                startActivityForResult(intent, 0x002);
                break;
            case R.id.tv_eighteen:
                break;
            case R.id.tv_flowers:
                break;
            case R.id.tv_select_citiy:
                startActivityForResult(new Intent(MinePatientDataActivity.this, SeclectCityActivity.class), 0x001);
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
                Intent intent1 = new Intent(MinePatientDataActivity.this, PatientRelationListActivity.class);
                intent1.putExtra("isreleation", "1");
                startActivityForResult(intent1, 0x003);
                break;
            case R.id.tv_diseases:
                break;
            case R.id.rl_patient_relation:
//                startActivityForResult(new Intent(PatientDataActivity.this, PatientRelationListActivity.class),0x002);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 0x001) {
                if (data != null) {
                    //选择城市所返回的code值与城市名
                    mAddressname = data.getStringExtra("addressname");
                    mAddresscode = data.getStringExtra("addresscode");
                    mTvSelectCitiy.setText(mAddressname);
                    Toast.makeText(this, mAddressname, Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == 0x002) {
                //患者关系列表返回的名字
                mRelationName = data.getStringExtra("relationName");
                mRelationNameBianma = data.getStringExtra("relationNameBianma");
                Log.i("patient_relation_bianma", mRelationNameBianma);
                Log.i("patient_relation_name", mRelationName);
                mTvRelationName.setText(mRelationName);
            } else if (requestCode == 0x003) {
                //疾病种类返回的名字
                mDiseaseName = data.getStringExtra("DiseaseName");
                mDiseaseId = data.getStringExtra("uuid");
                mTvDiseases.setText(mDiseaseName);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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
