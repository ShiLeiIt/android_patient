package cn.qiyu.magicalcrue_patient.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.MyScalePresenter;
import cn.qiyu.magicalcrue_patient.visit.MyScaleView;

/**
 * Created by ShiLei on 2017/11/30.
 * 已填写量表
 */

public class FiScaleFragment extends Fragment {
    @Bind(R.id.rcl_fi_scale)
    RecyclerView mRclFiScale;
    private String mPaperID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fi_scale, container, false);
        ButterKnife.bind(this, view);
        mMyScalePresenter.VisitScaleData();
        return view;
    }

    MyScalePresenter mMyScalePresenter = new MyScalePresenter(new MyScaleView() {
        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "");
        }

        @Override
        public String getStatus() {
            return "1";
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
            mRclFiScale.setAdapter(new FiScaleFragment.RecyclerAdpter( model.getData()));
            mRclFiScale.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        @Override
        public String paperId() {
            return null;
        }

        @Override
        public String paperUserId() {
            return null;
        }

        @Override
        public String userId() {
            return null;
        }

        @Override
        public void LoadScaleDetailsData(ResultModel<ScaleDetailBean> model) {

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_group_name, R.id.tv_group_member})
        TextView[] mtextview;
        MyScaleBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPaperID = mModel.getPaperID();

//                    scalePresenter1.questionNaireDetail();
                }
            });

        }

        void setItem(MyScaleBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String creatTime = mModel.getCreate_time().substring(0, 10);
            mtextview[0].setText(mModel.getPaperTitle());
            mtextview[1].setText(creatTime);
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<FiScaleFragment.ViewHolder> {
        private List<MyScaleBean> mlist;

        public RecyclerAdpter(List<MyScaleBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public FiScaleFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new FiScaleFragment.ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_item, null));
        }

        @Override
        public void onBindViewHolder(FiScaleFragment.ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }


        @OnClick(R.id.rcl_fi_scale)
        public void onViewClicked() {
        }
    }
}
