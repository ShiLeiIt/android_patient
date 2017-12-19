package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryHospitalListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;

/**
 * Created by ShiLei on 2017/12/19.
 */

public class HospitalListActivity extends BaseActivity {
    @Bind(R.id.iv_hospital_list_back)
    ImageView mIvHospitalListBack;
    @Bind(R.id.searchView)
    SearchView mSearchView;
    @Bind(R.id.tv_search_cancel)
    TextView mTvSearchCancel;
    @Bind(R.id.rlv_hospital_list)
    RecyclerView mRlvHospitalList;
    private String mHospitalName;
    private RecyclerAdpter mRecyclerAdpter;

    private List<HospitalListBean> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        ButterKnife.bind(this);
        init();
        initData();
    }



    private void init() {
        int searchId = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView tvSearch = (TextView) mSearchView.findViewById(searchId);
        tvSearch.setTextColor(getResources().getColor(R.color.app_gray));
        tvSearch.setHintTextColor(getResources().getColor(R.color.app_gray));
        tvSearch.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) tvSearch.getLayoutParams();
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.dp__3);
        tvSearch.setLayoutParams(layoutParams);

        mRlvHospitalList.addItemDecoration(new RecycleViewDivider(HospitalListActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.relation_bg));


    }
    CaseHistoryPresenter mCaseHistoryPresenter = new CaseHistoryPresenter(new CaseHistoryHospitalListView() {
        @Override
        public String getKeyWords() {
            return "";
        }

        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPageCount() {
            return "100";
        }

        @Override
        public void LoadHospitalList(ResultModel<List<HospitalListBean>> model) {
            mRecyclerAdpter = new RecyclerAdpter(model.getData());
            mRlvHospitalList.setAdapter(mRecyclerAdpter);
            mRlvHospitalList.setLayoutManager(new LinearLayoutManager(HospitalListActivity.this));
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
    private void initData() {
        //设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (mList!=null&&mList.size()>0) {
                    final List<HospitalListBean> filteredModelList = filter(mList, newText);
                    //reset
                    mRecyclerAdpter.setFilter(filteredModelList);
                    mRecyclerAdpter.animateTo(filteredModelList);
                    mRlvHospitalList.scrollToPosition(0);
                }



                return true;
            }
        });
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mRecyclerAdpter.setFilter(mList);
                return false;
            }
        });
        mCaseHistoryPresenter.getHospitalList();
    }
    private List<HospitalListBean> filter(List<HospitalListBean> peoples, String query) {
        query = query.toLowerCase();

        final List<HospitalListBean> filteredModelList = new ArrayList<>();
        for (HospitalListBean hospitalListBean : peoples) {

            final String nameEn = hospitalListBean.getHospitalName().toLowerCase();
//            final String desEn = people.getDescription().toLowerCase();
            final String name = hospitalListBean.getHospitalName();
//            final String des = people.getDescription();

            if (name.contains(query)  || nameEn.contains(query) ) {

                filteredModelList.add(hospitalListBean);
            }
        }
        return filteredModelList;
    }

    @OnClick({R.id.iv_hospital_list_back, R.id.tv_search_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hospital_list_back:
                break;
            case R.id.tv_search_cancel:
                break;
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        HospitalListBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(HospitalListBean item) {
            this.mModel = item;

        }

        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getHospitalName());
            if (mModel.isSelect()) {
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            } else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }
    public class RecyclerAdpter extends RecyclerView.Adapter<HospitalListActivity.ViewHolder> {


        public RecyclerAdpter(List<HospitalListBean> mlist) {
            mList = mlist;
        }

        @Override
        public HospitalListActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HospitalListActivity.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));
        }


        @Override
        public void onBindViewHolder(final HospitalListActivity.ViewHolder holder, final int position) {
            holder.setItem(mList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(PatientRelationListActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                    mHospitalName = mList.get(position).getHospitalName();
//                    mBianma = mlist.get(position).getBIANMA();
                    for (int i = 0; i < mList.size(); i++) {
                        if (i == position) {
                            mList.get(i).setSelect(true);
                        } else {
                            mList.get(i).setSelect(false);
                        }
                    }
                    mRecyclerAdpter.notifyDataSetChanged();
                }
            });
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
        public void setFilter(List<HospitalListBean> hospitalListBeen) {
            mList = new ArrayList<>();
            mList.addAll(hospitalListBeen);
            notifyDataSetChanged();
        }
        public void animateTo(List<HospitalListBean> peoples) {
            applyAndAnimateRemovals(peoples);
            applyAndAnimateAdditions(peoples);
            applyAndAnimateMovedItems(peoples);
        }

        private void applyAndAnimateRemovals(List<HospitalListBean> peoples) {
            for (int i = mList.size() - 1; i >= 0; i--) {
                final HospitalListBean people = mList.get(i);
                if (!peoples.contains(people)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<HospitalListBean> peoples) {
            for (int i = 0, count = peoples.size(); i < count; i++) {
                final HospitalListBean people = mList.get(i);
                if (!mList.contains(people)) {
                    addItem(i, people);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<HospitalListBean> peoples) {
            for (int toPosition = peoples.size() - 1; toPosition >= 0; toPosition--) {
                final HospitalListBean people = peoples.get(toPosition);
                final int fromPosition = mList.indexOf(people);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }


        public HospitalListBean removeItem(int position) {
            final HospitalListBean people = mList.remove(position);
            notifyItemRemoved(position);
            return people;
        }


        public void addItem(int position, HospitalListBean people) {
            mList.add(position, people);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final HospitalListBean people = mList.remove(fromPosition);
            mList.add(toPosition, people);
            notifyItemMoved(fromPosition, toPosition);
        }

    }
}
