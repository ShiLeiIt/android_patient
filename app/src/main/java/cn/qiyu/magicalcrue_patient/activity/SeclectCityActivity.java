package cn.qiyu.magicalcrue_patient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.city.CityDistrictPresenter;
import cn.qiyu.magicalcrue_patient.city.CityDistrictView;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/21.
 */

public class SeclectCityActivity extends Activity {
    @Bind(R.id.tv_select_city)
    TextView mTvSelectCity;
    @Bind(R.id.tv_city_save)
    TextView mTvCitySave;
    @Bind(R.id.rel_select_city)
    RecyclerView mRelSelectCity;
    StringBuffer addresscode = new StringBuffer();
    StringBuffer addressname = new StringBuffer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        MyApplication.getInstance().addActivity(this);
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

    @OnClick(R.id.tv_city_save)
    public void onViewClicked() {
        Intent intent=new Intent();
        intent.putExtra("addresscode",addresscode.toString());
//        Toast.makeText(this, "code"+addresscode.toString(), Toast.LENGTH_SHORT).show();
        intent.putExtra("addressname",addressname.toString());
        setResult(RESULT_OK,intent);
        finish();
    }



    public class RecyclerAdpter extends RecyclerView.Adapter<SeclectCityActivity.ViewHolder> {
        private List<CityBean> mlist;

        public RecyclerAdpter(List mlist) {
            this.mlist = mlist;
        }

        @Override
        public SeclectCityActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SeclectCityActivity.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.relview_city_item, null));

        }

        @Override
        public void onBindViewHolder(SeclectCityActivity.ViewHolder holder, int position) {
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
                        addresscode.append(mModel.getCode() + ",");
                        addressname.append(mModel.getName() + "-");
                        mCityDistrictPresenter.getCity(mModel.getCode(), "1");
                    } else if (mModel.getLevelId() == 1) {
                        //市
                        addresscode.append(mModel.getCode() + ",");
                        addressname.append(mModel.getName() + "-");
                        mCityDistrictPresenter.getCity(mModel.getCode(), "2");
                    } else  {
                        //保存显示
                        mTvCitySave.setVisibility(View.VISIBLE);
                        addresscode.append(mModel.getCode() + ",");
                        addressname.append(mModel.getName());
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
            if (mModel.getLevelId()==2) {
                mIv_city_district.setVisibility(View.INVISIBLE);
            }

        }
    }
}
