package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtPresenter;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtView;
import cn.qiyu.magicalcrue_patient.view.SelectPicPopupWindow;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 用户信息界面
 */
public class UserInforActivity extends FragmentActivity implements View.OnClickListener {

    @Bind(R.id.iv_userinfor_back)
    ImageView mIvUserinforBack;
    @Bind(R.id.tv_save_userinfor)
    TextView mTvSaveUserinfor;
    @Bind(R.id.iv_head_arrows)
    ImageView mIvHeadArrows;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_real_name)
    TextView mTvRealName;
    @Bind(R.id.iv_name_arrows)
    ImageView mIvNameArrows;
    @Bind(R.id.tv_citiy)
    TextView mTvCitiy;
    @Bind(R.id.tv_select_citiy)
    TextView mTvSelectCitiy;
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
    @Bind(R.id.civ_head)
    CircleImageView mCivHead;
    private SelectPicPopupWindow mPicPopupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infor);
        ButterKnife.bind(this);

        mPicPopupWindow = new SelectPicPopupWindow(UserInforActivity.this,this );
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
    UserInforEdtPresenter mUserInforEdtPresenter=  new UserInforEdtPresenter(new UserInforEdtView() {
        @Override
        public String getUuId() {
            return "178";
        }

        @Override
        public String getPhotoPath() {
            return "12345678";
        }

        @Override
        public String getUser_name() {
            return mTvRealName.getText().toString();
        }

        @Override
        public String getBirthday() {
            return mTvSelectDate.getText().toString();
        }

        @Override
        public String getSex() {
            if (((Integer)(mIvGirl.getTag()))==1) {
                return "1";
            }
            return "0";
        }

        @Override
        public String getNative_place_cd() {
            return "260000,260100,260103";
        }

        @Override
        public void getUserInforEdt(ResultModel rlBean) {
            Intent intent = new Intent(UserInforActivity.this, PatientDataActivity.class);
            startActivity(intent);
        }

        @Override
        public void getCityInfor(ResultModel<List<CityBean>> ctBean) {
//            List<CityBean> data = ctBean.getData();

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(UserInforActivity.this, ""+model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(UserInforActivity.this, ""+e, Toast.LENGTH_SHORT).show();
        }
    });

    @OnClick({R.id.iv_userinfor_back, R.id.tv_save_userinfor, R.id.iv_head_arrows, R.id.iv_name_arrows,
            R.id.tv_select_citiy, R.id.iv_girl, R.id.iv_boy, R.id.tv_select_Date, R.id.civ_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_userinfor_back:
                break;
            case R.id.tv_save_userinfor:
                mUserInforEdtPresenter.getUserInforEdt();


                break;
            case R.id.iv_head_arrows:
                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_select_citiy:
                tvSelectCity();
                break;
            case R.id.iv_girl:
                mIvGirl.setTag(1);
                mIvBoy.setTag(0);
                    mIvGirl.setImageResource(R.drawable.check_box_select);
                    mIvBoy.setImageResource(R.drawable.check_box_normal);
                Toast.makeText(this, ""+ ((Integer)(mIvGirl.getTag())), Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_boy:
                mIvBoy.setTag(1);
                mIvGirl.setTag(0);
                    mIvBoy.setImageResource(R.drawable.check_box_select);
                    mIvGirl.setImageResource(R.drawable.check_box_normal);
                Toast.makeText(this, ""+ ((Integer)(mIvBoy.getTag())), Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_select_Date:
                tvSelectDate();
                break;
            case R.id.civ_head:
                        View inflate = getLayoutInflater().inflate(R.layout.activity_user_infor, null);
                mPicPopupWindow. showAtLocation(inflate, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
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
                showToast("数据初始化失败");
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
    private void tvSelectDate() {
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
                mTvSelectDate.setText(year + "-" + month + "-" + day);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_photo:
                //拍照
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case R.id.tv_local_photo:
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent1);
                break;
        }
    }
}
