package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.view.OptionsPopupWindow;

public class UserInforActivity extends AppCompatActivity implements OptionsPopupWindow.OnOptionsSelectListener {

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
    // 城区数组
    ArrayList<String> ProvinceList = new ArrayList<String>();
    ArrayList<ArrayList<String>> CityList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<ArrayList<String>>> CountyList = new ArrayList<ArrayList<ArrayList<String>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infor);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_userinfor_back, R.id.tv_save_userinfor, R.id.iv_head_arrows, R.id.iv_name_arrows, R.id.tv_select_citiy, R.id.iv_girl, R.id.iv_boy, R.id.tv_select_Date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_userinfor_back:
                break;
            case R.id.tv_save_userinfor:
                break;
            case R.id.iv_head_arrows:
                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_select_citiy:
                getWheelList();
                OptionsPopupWindow popupWindow = new OptionsPopupWindow(UserInforActivity.this);
                popupWindow.showAtLocation(mTvSelectCitiy, Gravity.BOTTOM, 0, 0);//textView
                popupWindow.setPicker(ProvinceList, CityList, CountyList, true);
                popupWindow.setOnoptionsSelectListener(this);
                popupWindow.setCyclic(false);

                break;
            case R.id.iv_girl:
                break;
            case R.id.iv_boy:
                break;
            case R.id.tv_select_Date:
                break;
        }
    }

    @Override
    public void onOptionsSelect(int options1, int option2, int options3) {
        mTvSelectCitiy.setText(ProvinceList.get(options1) + CityList.get(options1).get(option2) + CountyList.get(options1).get(option2).get(options3));
        Toast.makeText(UserInforActivity.this, "" + mTvSelectCitiy.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    private void getWheelList() {
        try {
            // 获取json文件输入流
            InputStream is = getResources().getAssets().open("china_address.json");

            // 将json文件读入为一个字符串
            byte[] bytearray = new byte[is.available()];
            is.read(bytearray);
            String address_json = new String(bytearray, "UTF-8");

            // 将json转化为JSONArray对象,这是所有省的JSONArray
            JSONArray jsonArraySheng = new JSONArray(address_json);

            // 遍历这个JSONArray对象
            for (int i = 0; i < jsonArraySheng.length(); i++) {
                // 取出第i个省对象，并将其转化为JSONObject对象
                JSONObject jsonObjectSheng = jsonArraySheng.getJSONObject(i);
                // 将省的名字存入一维数组
                StringBuffer provincename = new StringBuffer(jsonObjectSheng.getString("areaName"));
                ProvinceList.add(provincename.toString());
                // 存储第i个省的城市名的数组
                ArrayList<String> tempj = new ArrayList<String>();
                // 存储第i个省的所有城市的城区名的二维数组
                ArrayList<ArrayList<String>> tempk = new ArrayList<ArrayList<String>>();
                // 取出第i个省对象中的城市数组，并将其转化为JSONArray对象
                JSONArray jsonArrayShi = jsonObjectSheng.getJSONArray("cities");
                // 遍历第i个省的城市JSONArray
                for (int j = 0; j < jsonArrayShi.length(); j++) {
                    // 取出第i个省的第j个市，并将其转化为JSONObject对象
                    JSONObject jsonObjectShi = jsonArrayShi.getJSONObject(j);
                    // 将市的名字存入第i个省的城市名数组
                    StringBuffer cityname = new StringBuffer(jsonObjectShi.getString("areaName"));
                    tempj.add(cityname.toString());
                    // 存储第i个省第j个市的城区名的数组
                    ArrayList<String> tempkk = new ArrayList<String>();
                    // 取出第i个省第j个市中的城区数组，并将其转化为JSONArray对象
                    JSONArray jsonArrayQu = jsonObjectShi.getJSONArray("counties");
                    // 遍历第i个省第j个市的城区JSONArray
                    for (int k = 0; k < jsonArrayQu.length(); k++) {
                        // 第i个省第j个市第k个区
                        JSONObject jsonObjectQu = jsonArrayQu.getJSONObject(k);
                        // 名字存入数组
                        StringBuffer countyname = new StringBuffer(jsonObjectQu.getString("areaName"));
                        tempkk.add(countyname.toString());
                    }
                    // 第i个省第j个市的城区名的数组添加到第i个省的所有城市的城区名的二维数组
                    tempk.add(tempkk);
                }
                CityList.add(tempj);
                CountyList.add(tempk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
