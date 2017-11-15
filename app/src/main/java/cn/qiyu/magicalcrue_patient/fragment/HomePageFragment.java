package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.CommonAdapter;
import cn.qiyu.magicalcrue_patient.adapter.ViewHolder;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.view.LLImageView;
import cn.qiyu.magicalcrue_patient.view.LLTextView;
import cn.qiyu.magicalcrue_patient.view.ListViewForScrollView;

/**
 * Created by Administrator on 2017/11/13.
 * 首页界面
 */

public class HomePageFragment extends Fragment {
    private ListViewForScrollView mLv_sv;
    private TextView mTv_topleft;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        LLImageView viewById = (LLImageView)view.findViewById(R.id.iv_doctor_icon);
        LLTextView llTvVisit = (LLTextView)view.findViewById(R.id.ll_tv_visit);
        mTv_topleft = (TextView)llTvVisit.findViewById(R.id.tv_top_left);
        HomePresenter homePresenter=new HomePresenter(new HomeNumView() {
            @Override
            public String getUserId() {
                return "5d9976d752c541c5a4608bc2758c54d7";
            }

            @Override
            public void LoadDate(HomeNumBean numBean) {

                if (numBean.getData() != null) {
                    mTv_topleft.setText(String.valueOf(numBean.getData().getFollowDay()));
                } else {
                    Toast.makeText(getActivity(),"1111",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void onServerFailure(String e) {

            }
        });
        homePresenter.HomeLoadNumData();

        String[] array = new String[4];
        viewById.setDatas(array);
        mLv_sv = (ListViewForScrollView) view.findViewById(R.id.lv_home_image);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        MyAdapter myAdapter = new MyAdapter(getActivity(), strings, R.layout.adpter_home_more);
        mLv_sv.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public class MyAdapter extends CommonAdapter<String> {
        public MyAdapter(Context context, List<String> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, String item, int positon) {
            helper.setImageResource(R.id.adapter_iv_item, R.drawable.banner);
        }
    }


}
