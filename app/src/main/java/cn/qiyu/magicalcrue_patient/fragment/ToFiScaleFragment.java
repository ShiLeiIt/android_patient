package cn.qiyu.magicalcrue_patient.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.ScaleDetailActivity;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.MyScalePresenter;
import cn.qiyu.magicalcrue_patient.visit.MyScaleView;

/**
 * Created by ShiLei on 2017/11/30.
 * 待填写量表
 */

public class ToFiScaleFragment extends Fragment {

    @Bind(R.id.rcl_tofi_scale)
    RecyclerView mRclTofiScale;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;
    private String mQuestionUUid;
    private int mPaperUserID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tofi_scale, container, false);
        ButterKnife.bind(this, view);
        mScalePresenter.VisitScaleData();
        getLoad();
        return view;
    }


    MyScalePresenter mScalePresenter = new MyScalePresenter(new MyScaleView() {

        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "");
        }

        @Override
        public String getStatus() {
            return "0";
        }

        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPagecount() {
            return "100";
        }

        @Override
        public void LoadDate(ResultModel<List<MyScaleBean>> model) {
//            Toast.makeText(getActivity(), ""+model.getMessage(), Toast.LENGTH_SHORT).show();
            mSwipeLayout.setRefreshing(false);
            mRclTofiScale.setAdapter(new RecyclerAdpter(model.getData()));
            mRclTofiScale.setLayoutManager(new LinearLayoutManager(getActivity()));

        }

        @Override
        public String paperId() {
            return mQuestionUUid;
        }

        @Override
        public String paperUserId() {
            return String.valueOf(mPaperUserID);
        }

        @Override
        public String userId() {
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "0");
        }

        @Override
        public void LoadScaleDetailsData(ResultModel<ScaleDetailBean> model) {
            Intent intent = new Intent(getActivity(), ScaleDetailActivity.class);
            intent.putExtra("scaleDetail", model.getData());
            intent.putExtra("paperUserID", String.valueOf(mPaperUserID));
//            Log.i("paperUserID---------=", model.getData().getUserID());
            startActivity(intent);
        }


        @Override
        public String getQuestionArr() {
            return null;
        }

        @Override
        public void LoadScaleDetailsCommit(ResultModel model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
//            Toast.makeText(getActivity(), ""+model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
//            Toast.makeText(getActivity(), ""+e, Toast.LENGTH_SHORT).show();
        }
    });

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_group_name, R.id.tv_group_member, R.id.tv_scale_satus})
        TextView[] mtextview;
        MyScaleBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mQuestionUUid = mModel.getPaperID();
                    mPaperUserID = mModel.getPaperUserID();
                    Log.i("paperUserID", mPaperUserID + "");
                    mScalePresenter.VisitScaleDetailsData();

                }
            });

        }

        void setItem(MyScaleBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String creatTime = mModel.getCreate_time();
            int status = mModel.getStatus();
            mtextview[0].setText(mModel.getPaperTitle());
            mtextview[1].setText(creatTime);
            if (status == 0) {
                mtextview[2].setText("未填写");
                mtextview[2].setTextColor(getResources().getColor(R.color.app_gray));
            } else {
                mtextview[2].setText("已填写");
                mtextview[2].setTextColor(getResources().getColor(R.color.app_relation_tv));
            }

        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<MyScaleBean> mlist;

        public RecyclerAdpter(List<MyScaleBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_item, null));
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
    public void getLoad() {

/*加载的渐变动画*/
        mSwipeLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mScalePresenter.VisitScaleData();
            }
        });
    }
}
