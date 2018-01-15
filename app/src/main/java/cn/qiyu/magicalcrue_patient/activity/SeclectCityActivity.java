package cn.qiyu.magicalcrue_patient.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.city.CityDistrictPresenter;
import cn.qiyu.magicalcrue_patient.city.CityDistrictView;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/21.
 */

public class SeclectCityActivity extends BaseActivity {
    @Bind(R.id.tv_select_city)
    TextView mTvSelectCity;
    @Bind(R.id.tv_city_save)
    TextView mTvCitySave;
    @Bind(R.id.rel_select_city)
    RecyclerView mRelSelectCity;

    StringBuffer addresscode = new StringBuffer();
    StringBuffer addressname = new StringBuffer();
    private static String addresscode_one = "";
    private static String addressname_one = "";
    private static String addresscode_tow = "";
    private static String addressname_tow = "";
    private static String addresscode_three = "";
    private static String addressname_three = "";
    private static int LevelId;
    private static boolean isCity=true;
    private static String code2 = "";
    private static String name2="";
    @Bind(R.id.rl_exit_upper)
    RelativeLayout mRlExitUpper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        ButterKnife.bind(this);
        mCityDistrictPresenter.getCity("1", "0");
    }

    CityDistrictPresenter mCityDistrictPresenter = new CityDistrictPresenter(new CityDistrictView() {
        @Override
        public String getParentCode(String code) {
            return code;
        }

        @Override
        public String getLevelId(String levelId) {
            return levelId;
        }

        @Override
        public void getCityInfor(ResultModel<List<CityBean>> ctBean) {
            if(isCity){
                mRlExitUpper.setVisibility(View.INVISIBLE);
            }else {
                mRlExitUpper.setVisibility(View.VISIBLE);
            }

            mRelSelectCity.setAdapter(new RecyclerAdpter(ctBean.getData()));
            mRelSelectCity.setLayoutManager(new LinearLayoutManager(SeclectCityActivity.this));
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(SeclectCityActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(SeclectCityActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });

    @OnClick({R.id.tv_city_save, R.id.rl_exit_upper})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_city_save:
                addressname.append(addressname_one);
                addresscode.append(addresscode_one);
                addressname.append(addressname_tow);
                addresscode.append(addresscode_tow);
                addressname.append(addressname_three);
                addresscode.append(addresscode_three);
                Intent intent = new Intent();
                intent.putExtra("addresscode", addresscode.toString());
//        Toast.makeText(this, "code"+addresscode.toString(), Toast.LENGTH_SHORT).show();
                intent.putExtra("addressname", addressname.toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.rl_exit_upper:
                mTvCitySave.setVisibility(View.INVISIBLE);
                switch (LevelId) {
                    case 0:
                        isCity=true;
                        mCityDistrictPresenter.getCity("1", "0");
                        mTvSelectCity.setText("请选择");
                        break;
                    case 1:
                    case 2:
                        mCityDistrictPresenter.getCity(code2, "1");
                        LevelId = 0;
                        mTvSelectCity.setText(name2);

                        break;
                }

                break;

        }
    }


    public class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<CityBean> mlist;

        public RecyclerAdpter(List mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.relview_city_item, null));

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CityBean mModel;
        TextView mTv_city;
        ImageView mIv_city_district;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTv_city = (TextView) itemView.findViewById(R.id.tv_city_district);
            mIv_city_district = (ImageView) itemView.findViewById(R.id.iv_city_district_arrows);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTvSelectCity.setText(mModel.getName());
                    if (mModel.getLevelId() == 0) {
                        //省
                        addresscode_one = mModel.getCode() + ",";
                        addressname_one = mModel.getName() + "-";
                        mCityDistrictPresenter.getCity(mModel.getCode(), "1");
                        code2 = mModel.getCode();
                        name2=mModel.getName();
                        isCity=false;

                    } else if (mModel.getLevelId() == 1) {
                        //市
                        addresscode_tow = mModel.getCode() + ",";
                        addressname_tow = mModel.getName() + "-";
                        mCityDistrictPresenter.getCity(mModel.getCode(), "2");
                        LevelId = mModel.getLevelId();


                    } else {
                        //保存显示
                        mTvCitySave.setVisibility(View.VISIBLE);
                        addresscode_three = mModel.getCode();
                        addressname_three = mModel.getName();
                        LevelId = mModel.getLevelId();
                        //code=mModel.getCode();
                    }


                }
            });
        }

        void setItem(CityBean item) {
            this.mModel = item;

        }

        //        刷新
        void refreshView() {
            mTv_city.setText(mModel.getName());
            if (mModel.getLevelId() == 2) {
                mIv_city_district.setVisibility(View.INVISIBLE);
            }

        }
    }
}
