package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.register_login.RegisterPresenter;
import cn.qiyu.magicalcrue_patient.register_login.RegisterVmView;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * 注册登录页面
 */
public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.iv_register_del)
    ImageView mIvRegisterDel;
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    @Bind(R.id.tv_send_auth_code)
    TextView mTvSendAuthCode;
    @Bind(R.id.iv_register_auth)
    ImageView mIvRegisterAuth;
    @Bind(R.id.tv_deal)
    TextView mTvDeal;
    @Bind(R.id.iv_register)
    ImageView mIvRegister;
    @Bind(R.id.edit_auth_code)
    EditText mEditAuthCode;
    @Bind(R.id.iv_login)
    ImageView mIv_login;
    private TimeCount mTimeCount;
    public boolean tag = true;
    private RegisterPresenter mRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        String uuid = (String) PreUtils.getParam(RegisterActivity.this, "uuid", "0");
        if (!uuid.equals("0")) {
            switch ((Integer) PreUtils.getParam(RegisterActivity.this,"userperfect",0)) {
                case 1:
                    Intent intentUser = new Intent(RegisterActivity.this, UserInforActivity.class);
                    startActivity(intentUser);
                    break;
                case 2:
                    Intent intentPatient = new Intent(RegisterActivity.this, PatientDataActivity.class);
                    startActivity(intentPatient);
                    break;
                default:
                    Intent intentMain = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intentMain);
                    break;
            }
        }

        //构造CountDownTimer对象
        mTimeCount = new TimeCount(60000, 1000);
        mRegisterPresenter = new RegisterPresenter(new RegisterVmView() {
            @Override
            public String getAccount() {
//                Toast.makeText(RegisterActivity.this, "22222222", Toast.LENGTH_SHORT).show();
                return mEditPhone.getText().toString();
            }

            @Override
            public void getVerifyMessage(ResultModel rlBean) {
                Toast.makeText(RegisterActivity.this, rlBean.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public String getVerCode() {
                return mEditAuthCode.getText().toString();
            }

            @Override
            public String getJpushId() {
                return "";
            }

            @Override
            public void getRegisterLogin(ResultModel<RegisterLoginBean> model) {
                int userPerfect = model.getData().getUserPerfect();
                if (userPerfect==1) {
                    PreUtils.setParam(RegisterActivity.this, "uuid", model.getData().getUuid());
                    PreUtils.setParam(RegisterActivity.this, "userperfect", model.getData().getUserPerfect());
                    PreUtils.setParam(RegisterActivity.this, "userid", String.valueOf(model.getData().getId()));
//                        Toast.makeText(RegisterActivity.this, "用户信息界面", Toast.LENGTH_SHORT).show();
                    Intent intentUser = new Intent(RegisterActivity.this, UserInforActivity.class);
                    startActivity(intentUser);
                } else if (userPerfect == 2) {
                    PreUtils.setParam(RegisterActivity.this, "uuid", model.getData().getUuid());
                    PreUtils.setParam(RegisterActivity.this, "userperfect", model.getData().getUserPerfect());
                    PreUtils.setParam(RegisterActivity.this, "token", model.getData().getToken());
                    PreUtils.setParam(RegisterActivity.this, "userid", String.valueOf(model.getData().getId()));
//                        Toast.makeText(RegisterActivity.this, "患者信息界面", Toast.LENGTH_SHORT).show();
                    Intent intentPatient = new Intent(RegisterActivity.this, PatientDataActivity.class);
                    startActivity(intentPatient);

                } else {
                    PreUtils.setParam(RegisterActivity.this, "uuid", model.getData().getUuid());
                    PreUtils.setParam(RegisterActivity.this, "patientuuid", model.getData().getMedical_record_uuid());
                    PreUtils.setParam(RegisterActivity.this, "patientuuid", model.getData().getMedical_record_uuid());
                    Intent intentPatient = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intentPatient);
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
                Toast.makeText(RegisterActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerFailure(String e) {
                Toast.makeText(RegisterActivity.this, e, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({R.id.iv_register_del, R.id.edit_phone, R.id.tv_send_auth_code, R.id.iv_register_auth, R.id.tv_deal, R.id.iv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_register_del:
                break;
            case R.id.edit_phone:
                break;
            case R.id.tv_send_auth_code:
                mTimeCount.start();
                mTvSendAuthCode.setBackgroundResource(R.drawable.register_auth_code_show);
                mTvSendAuthCode.setTextColor(getResources().getColor(R.color.app_white));
//                mEditAuthCode.setEnabled(true);
                mRegisterPresenter.RegisterLoadMesData();
                break;
            case R.id.iv_register_auth:
                if (tag) {
                    mIvRegisterAuth.setImageResource(R.drawable.register_pitch_on);
                    tag = false;
                } else {
                    mIvRegisterAuth.setImageResource(R.drawable.register_jzmm);
                    tag = true;
                }
                break;
            case R.id.tv_deal:
                break;
            case R.id.iv_register:
                if (TextUtils.isEmpty(mEditPhone.getText())) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mEditAuthCode.getText())) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                } else if (tag) {
                    Toast.makeText(this, "请同意注册协议", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    mRegisterPresenter.RegisterLogin();

                }
                break;
        }
    }

    /* 定义一个倒计时的内部类 */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            mTvSendAuthCode.setBackgroundResource(R.drawable.register_auth_code);
            mTvSendAuthCode.setText("重新验证");
            mTvSendAuthCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            mTvSendAuthCode.setClickable(false);
            mTvSendAuthCode.setText(millisUntilFinished / 1000 + "秒");
        }
    }
}


